package expression;

import exception.BadOperation;
import exception.Overflow;
import operations.Operation;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
public class CheckedDivide<T> extends AbstractBinary<T> {
    public CheckedDivide(final TripleExpression<T> x, final TripleExpression<T> y, final Operation<T> z) {
        super(x, y, z);
    }

    protected T apply(final T x, final T y) throws BadOperation, Overflow {
        return type.div(x, y);
    }
}