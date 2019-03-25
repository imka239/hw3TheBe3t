package expression;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */

public class Const<T> implements TripleExpression<T> {
    private final T val;

    public Const(final T x) {
        val = x;
    }

    public T evaluate(final T x, final T y, final T z) {
        return val;
    }
}
