package expression;

/**
 * Created by Dmitry Gnatyuk on 30.12.2018.
 */
import exception.ImpossibleOperation;

public interface TripleExpression<T> {
    T evaluate(T x, T y, T z) throws ImpossibleOperation;
}

