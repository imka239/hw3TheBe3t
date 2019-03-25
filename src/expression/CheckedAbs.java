package expression;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
import exception.ImpossibleOperation;
import exception.Overflow;
import operations.Operation;

public class CheckedAbs<T> extends AbstractUnary<T> {
    public CheckedAbs(final TripleExpression<T> abs, final Operation<T> type) {
        super(abs, type);
    }


    protected T apply(final T x) throws Overflow {
        return type.abs(x);
    }
}

