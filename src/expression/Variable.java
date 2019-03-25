package expression;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
public class Variable<T> implements TripleExpression<T> {
    private final char name;

    public Variable(final char x) {
        name = x;
    }

    public T evaluate(final T x, final T y, final T z) {
        switch (name) {
            case 'x':
                return x;
            case 'y':
                return y;
            case 'z':
                return z;
            default:
                return x;
        }
    }

}