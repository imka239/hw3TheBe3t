package expression;

import exception.*;
import operations.Operation;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
public class CheckedAdd<T> extends AbstractBinary<T> {
    public CheckedAdd(final TripleExpression<T> x, TripleExpression<T> y, final Operation<T> z) {
        super(x, y, z);
    }
    protected T apply(final T x, final T y) throws Overflow {
        return type.add(x, y);
    }
}
