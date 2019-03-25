package operations;

import exception.BadOperation;
import exception.Constant;
import exception.Overflow;

public class UnIntOp implements Operation<Integer> {
    public UnIntOp() {
    }

    public Integer parse(String number) throws Constant {
        return new Integer(number);
    }

    public Integer add(Integer x, Integer y) {
        return x + y;
    }

    public Integer sub(Integer x, Integer y) {
        return x - y;
    }

    public Integer mul(Integer x, Integer y) {
        return x * y;
    }

    public Integer max(Integer x, Integer y) {
        return x < y ? y : x;
    }

    public Integer min(Integer x, Integer y) {
        return x < y ? x : y;
    }

    public Integer div(Integer x, Integer y) throws BadOperation {
        if (y == 0) {
            throw new BadOperation("Division By Zero");
        } else {
            return x / y;
        }
    }

    public Integer neg(Integer x) {
        return -x;
    }

    public Integer abs(Integer x) {
        return Math.abs(x);
    }

    public Integer mod(Integer x, Integer y) throws BadOperation {
        if (y == 0) {
            throw new BadOperation("Module By Zero");
        } else {
            return x % y;
        }
    }

    public Integer sqr(Integer x) throws Overflow {
        return this.mul(x, x);
    }
}
