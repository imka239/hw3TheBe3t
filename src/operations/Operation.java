package operations;

import exception.BadOperation;
import exception.Constant;
import exception.Overflow;

public interface Operation<T> {

    T parse(String var1) throws Constant;
    T add(T var1, T var2) throws Overflow;
    T sub(T var1, T var2) throws Overflow;
    T mul(T var1, T var2) throws Overflow;
    T max(T var1, T var2);
    T min(T var1, T var2);
    T div(T var1, T var2) throws BadOperation, Overflow;
    T neg(T var1) throws Overflow;
    T abs(T var1) throws Overflow;
    T mod(T var1, T var2) throws BadOperation;
    T sqr(T var1) throws Overflow;

}
