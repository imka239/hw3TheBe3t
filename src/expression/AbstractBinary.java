package expression;

import exception.ImpossibleOperation;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */

import exception.*;
import operations.Operation;

public abstract class AbstractBinary<T> implements TripleExpression<T>  {
    private final TripleExpression<T> first, second;
    protected final Operation<T> type;

    protected AbstractBinary(final TripleExpression<T> x, final TripleExpression<T> y, final Operation<T> z) {
        first = x;
        second = y;
        type = z;
    }

    protected abstract T apply(final T x, final T y) throws ImpossibleOperation;

    public T evaluate(final T x, final T y, final T z) throws ImpossibleOperation{
        return apply(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }
}
