package operations;

import exception.BadOperation;
import exception.Overflow;

public class IntOp implements Operation<Integer> {
    public IntOp() {
    }

    public Integer parse(String number) {
        return Integer.parseInt(number);
    }

    public Integer add(Integer x, Integer y) throws Overflow {
        if (x > 0 && 2147483647 - x < y) {
            throw new Overflow();
        } else if (x < 0 && -2147483648 - x > y) {
            throw new Overflow();
        } else {
            return x + y;
        }
    }

    public Integer sub(Integer x, Integer y) throws Overflow {
        if (x >= 0 && y < 0 && x - 2147483647 > y) {
            throw new Overflow();
        } else if (x <= 0 && y > 0 && -2147483648 - x > -y) {
            throw new Overflow();
        } else {
            return x - y;
        }
    }

    public Integer mul(Integer x, Integer y) throws Overflow {
        if (x > 0 && y > 0 && 2147483647 / x < y) {
            throw new Overflow();
        } else if (x > 0 && y < 0 && -2147483648 / x > y) {
            throw new Overflow();
        } else if (x < 0 && y > 0 && -2147483648 / y > x) {
            throw new Overflow();
        } else if (x < 0 && y < 0 && 2147483647 / x > y) {
            throw new Overflow();
        } else {
            return x * y;
        }
    }

    public Integer max(Integer x, Integer y) {
        return x < y ? y : x;
    }

    public Integer min(Integer x, Integer y) {
        return x > y ? y : x;
    }

    public Integer div(Integer x, Integer y) throws BadOperation, Overflow {
        if (y == 0) {
            throw new BadOperation("Division by zero");
        } else {
            return x / y;
        }
    }

    public Integer neg(Integer x) throws Overflow {
        if (x == -2147483648) {
            throw new Overflow();
        } else {
            return -x;
        }
    }

    public Integer abs(Integer x) throws Overflow {
        if (x == -2147483648) {
            throw new Overflow();
        } else {
            return Math.abs(x);
        }
    }

    public Integer sqr(Integer x) throws Overflow {
        return this.mul(x, x);
    }

    public Integer mod(Integer x, Integer y) throws BadOperation {
        if (y == 0) {
            throw new BadOperation("Module by zero");
        } else {
            return x % y;
        }
    }
}
