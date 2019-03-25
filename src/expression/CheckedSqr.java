package expression;

import exception.Overflow;
import operations.Operation;

/**
 * Created by Dmitry Gnatyuk on 04.03.2019.
 */
public class CheckedSqr<T> extends AbstractUnary<T> {

    public CheckedSqr(final TripleExpression<T> x, Operation<T> z) {
        super(x, z);
    }


    protected T apply(final T x) throws Overflow {
        return type.sqr(x);
    }
}
