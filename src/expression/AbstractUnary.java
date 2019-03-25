package expression;

import base.BaseTest;
import exception.ImpossibleOperation;
import operations.Operation;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
public abstract class AbstractUnary<T> implements TripleExpression<T> {
    private final TripleExpression<T> operand;
    protected final Operation<T> type;

    protected AbstractUnary(final TripleExpression<T> x, final Operation<T> t) {
        operand = x;
        type = t;
    }

    protected abstract T apply(final T x) throws ImpossibleOperation;

    public T evaluate(final T x, final T y, final T z) throws ImpossibleOperation {
        return apply(operand.evaluate(x, y, z));
    }
}
