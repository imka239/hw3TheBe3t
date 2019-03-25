package expression;

import exception.Overflow;
import operations.Operation;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
public class CheckedNegate<T> extends AbstractUnary<T> {

    public CheckedNegate(final TripleExpression<T> x, Operation<T> z) {
        super(x, z);
    }


    protected T apply(final T x) throws Overflow {
        return type.neg(x);
    }
}
