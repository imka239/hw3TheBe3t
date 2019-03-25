package expression;

import exception.Overflow;
import operations.Operation;

/**
 * Created by Dmitry Gnatyuk on 10.02.2019.
 */
public class CheckedSubtract<T> extends AbstractBinary<T> {
    public CheckedSubtract(final TripleExpression<T> x, final TripleExpression<T> y, Operation<T> z) {
        super(x, y, z);
    }

    protected T apply(final T x, final T y) throws Overflow {
        return type.sub(x, y);
    }
}
