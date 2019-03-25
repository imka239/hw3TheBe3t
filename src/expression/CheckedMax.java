package expression;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
import exception.ImpossibleOperation;
import operations.Operation;

public class CheckedMax<T> extends AbstractBinary<T> {

    public CheckedMax(TripleExpression<T> left, TripleExpression<T> right, Operation<T> z) {
        super(left, right, z);
    }

    protected T apply(T x, T y) {
        return type.max(x, y);
    }
}