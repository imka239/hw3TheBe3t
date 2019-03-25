package operations;

import exception.BadOperation;
import exception.Constant;
import exception.Overflow;

public class FloOp implements Operation<Float> {
    public FloOp() {
    }

    public Float parse(String number) throws Constant {
        return new Float(number);
    }

    public Float add(Float x, Float y) {
        return x + y;
    }

    public Float sub(Float x, Float y) {
        return x - y;
    }

    public Float mul(Float x, Float y) {
        return x * y;
    }

    public Float max(Float x, Float y) {
        return x < y ? y : x;
    }

    public Float min(Float x, Float y) {
        return x < y ? x : y;
    }

    public Float div(Float x, Float y) throws BadOperation {
        return x / y;
    }

    public Float neg(Float x) {
        return -x;
    }

    public Float abs(Float x) {
        return Math.abs(x);
    }

    public Float mod(Float x, Float y) throws BadOperation {
        return x % y;
    }

    public Float sqr(Float x) throws Overflow {
        return this.mul(x, x);
    }
}
