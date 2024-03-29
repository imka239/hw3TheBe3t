package parser;

import expression.TripleExpression;
import exception.ParsingException;
import operations.Operation;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */


public interface Parser<T> {
    TripleExpression<T> parse(String expression) throws ParsingException;
}

