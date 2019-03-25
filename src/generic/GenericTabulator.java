package generic;

import exception.ImpossibleOperation;
import exception.ParsingException;
import exception.UnknownMode;
import expression.TripleExpression;
import operations.*;
import parser.ExpressionParser;

/**
 * Created by Dmitry Gnatyuk on 03.03.2019.
 */
public class GenericTabulator implements Tabulator {
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws UnknownMode, ParsingException {
        Operation<?> op = getOperation(mode);
        return strictTabulate(op, expression, x1, x2, y1, y2, z1, z2);
    }

    private  <T> Object[][][] strictTabulate(Operation<T> op, String expression, int x1, int x2, int y1, int y2,int z1, int z2) throws ParsingException {
        Object[][][] ans = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        TripleExpression<T> exp;
            exp = new ExpressionParser<>(op).parse(expression);
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int h = z1; h <= z2; h++) {
                    try {
                        ans[i - x1][j - y1][h - z1] = exp.evaluate(op.parse(Integer.toString(i)), op.parse(Integer.toString(j)), op.parse(Integer.toString(h)));
                    } catch (ParsingException | ImpossibleOperation ignored) {
                    }
                }
            }
        }
        return ans;
    }

    private Operation getOperation(String in) throws UnknownMode {
        switch (in){
            case "i" :
                return new IntOp();
            case "bi" :
                return new BiIntOp();
            case "d" :
                return new DoOp();
            case "f" :
                return new FloOp();
            case "b" :
                return new ByOp();
            case "u" :
                return new UnIntOp();
            default:
                throw new UnknownMode(in);
        }
    }
}
