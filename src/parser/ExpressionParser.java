package parser;

import exception.Brackets;
import exception.EndException;
import exception.ForgottenArgument;
import exception.ParsingException;
import expression.*;
import operations.Operation;

public class ExpressionParser<T> implements Parser<T> {
    private String expression;
    private char varName;
    private Token curr;
    private int ind, opInd;
    private Operation<T> operation;
    public ExpressionParser(Operation<T> op) {
        operation = op;
    }
    public TripleExpression<T> parse(String in) throws ParsingException {
        expression = in;
        curr = Token.BEGIN;
        ind = 0;
        TripleExpression<T> res = addSub();
        if (curr != Token.END) {
            throw new EndException("Expected end of expression, in", ind);
        } else {
            return res;
        }
    }

    private TripleExpression<T> addSub() throws ParsingException {
        TripleExpression<T> res = mulDiv();
        while (true) {
            switch (curr) {
                case ADD:
                    res = new CheckedAdd<>(res, mulDiv(), operation);
                    break;
                case SUB:
                    res = new CheckedSubtract<>(res, mulDiv(), operation);
                    break;
                default:
                    return res;
            }
        }
    }

    private TripleExpression<T> mulDiv() throws ParsingException {
        TripleExpression<T> res = unary();
        while (true) {
            switch (curr) {
                case MULT:
                    res = new CheckedMultiply<>(res, unary(), operation);
                    break;
                case DIV:
                    res = new CheckedDivide<>(res, unary(), operation);
                    break;
                case MOD:
                    res = new CheckedMod<>(res, unary(), operation);
                default:
                    return res;
            }
        }
    }

    private TripleExpression<T> unary() throws ParsingException {
        TripleExpression<T> res;
        switch (getToken()) {
            case OP_BRACE:
                res = addSub();
                if (curr != Token.CL_BRACE) {
                    throw new Brackets("No closing Brackets", ind);
                }
                getToken();
                break;
            case VAR:
                res = new Variable<>(varName);
                getToken();
                break;
            case NUMBER:
                res = new Const<>(getNumber());
                getToken();
                break;
            case NEG:
                return new CheckedNegate<>(unary(), operation);
            case ABS:
                return new CheckedAbs<>(unary(), operation);
            case SQR:
                return new CheckedSqr<>(unary(), operation);
            default:
                throw new ForgottenArgument("Missed operand in position", opInd);
        }
        return res;
    }

    private  Token getToken() throws ForgottenArgument {
        Token left = curr;
        skipWhitespaces();
        if (ind >= expression.length()) {
            curr = Token.END;
            return curr;
        }
        char symb = expression.charAt(ind);
        switch (symb) {
            case '(':
                curr = Token.OP_BRACE;
                break;
            case ')':
                opInd = ind;
                curr = Token.CL_BRACE;
                break;
            case 'x':
            case 'y':
            case 'z':
                varName = symb;
                curr = Token.VAR;
                break;
            case '+':
                opInd = ind;
                curr = Token.ADD;
                break;
            case '-':
                if (canBeLeft(left)) {
                    curr = Token.SUB;
                } else if (ind + 1 < expression.length() && Character.isDigit(ind + 1)) {
                    curr = Token.NUMBER;
                } else {
                    curr = Token.NEG;
                }
                break;
            case '*':
                opInd = ind;
                curr = Token.MULT;
                break;
            case '/':
                opInd = ind;
                curr = Token.DIV;
                break;
            default:
                if (Character.isDigit(symb)) {
                    curr = Token.NUMBER;
                    break;
                }
                ind++;
                String func = getOperation();
                switch (func) {
                    case "mod":
                        curr = Token.MOD;
                        break;
                    case "abs":
                        curr = Token.ABS;
                        break;
                    case "square":
                        curr = Token.SQR;
                        break;
                    default:
                        throw new ForgottenArgument("Unsupported operation " + func + ", position", ind);
                }
                ind--;
        }
        ind++;
        return curr;
    }

    private String getOperation() {
        int left = ind - 1;
        while (ind < expression.length() && Character.isLetter(expression.charAt(ind))) {
            ind++;
        }
        return  expression.substring(left, ind);
    }

    private T getNumber() throws ParsingException {
        int left = ind - 1;
        while (ind < expression.length() && Character.isDigit(expression.charAt(ind))) {
            ind++;
        }
        return operation.parse(expression.substring(left, ind));
    }

    private boolean canBeLeft(Token left) {
        return left == Token.VAR || left == Token.NUMBER || left == Token.CL_BRACE;
    }

    private void skipWhitespaces() {
        while (ind < expression.length() && Character.isWhitespace(expression.charAt(ind))) {
            ind++;
        }
    }

}

enum Token {OP_BRACE, CL_BRACE, VAR, NUMBER, ADD, SUB, MULT, DIV, NEG, BEGIN, MOD, END, ABS, SQR}