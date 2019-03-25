package expression;

import exception.BadOperation;
import exception.ImpossibleOperation;
import exception.Overflow;
import operations.Operation;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
public class CheckedMod<T> extends AbstractBinary<T> {
    public CheckedMod(TripleExpression<T> term1, TripleExpression<T> term2, Operation<T> z) {
        super(term1, term2, z);
    }

    protected T apply(T x, T y) throws BadOperation {
        return type.mod(x, y);
    }

}
