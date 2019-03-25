package expression;

import operations.Operation;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
public class CheckedMin<T> extends AbstractBinary<T> {
    public CheckedMin(final TripleExpression<T> x, final TripleExpression<T> y, Operation<T> z) {
        super(x, y, z);
    }

    protected T apply(final T x, final T y) {
        return type.min(x, y);
    }
}