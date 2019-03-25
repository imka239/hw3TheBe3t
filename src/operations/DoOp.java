package operations;

import exception.BadOperation;
import exception.Constant;
import exception.Overflow;

public class DoOp implements Operation<Double> {
    public DoOp() {
    }

    public Double parse(String number) throws Constant {
        return new Double(number);
    }

    public Double add(Double x, Double y) {
        return x + y;
    }

    public Double sub(Double x, Double y) {
        return x - y;
    }

    public Double mul(Double x, Double y) {
        return x * y;
    }

    public Double max(Double x, Double y) {
        return x < y ? y : x;
    }

    public Double min(Double x, Double y) {
        return x < y ? x : y;
    }

    public Double div(Double x, Double y) throws BadOperation {
        return x / y;
    }

    public Double neg(Double x) {
        return -x;
    }

    public Double abs(Double x) {
        return Math.abs(x);
    }

    public Double mod(Double x, Double y) throws BadOperation {
        return x % y;
    }

    public Double sqr(Double x) throws Overflow {
        return this.mul(x, x);
    }
}
