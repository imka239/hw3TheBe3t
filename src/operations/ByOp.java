package operations;

import exception.BadOperation;
import exception.Constant;
import exception.Overflow;


/**
 * Created by Dmitry Gnatyuk on 03.03.2019.
 */
public class ByOp implements Operation<Byte> {
    public ByOp() {
    }

    public Byte parse(String number) throws Constant {
        return (byte)Integer.parseInt(number);
    }

    public Byte add(Byte x, Byte y) {
        return (byte)(x + y);
    }

    public Byte sub(Byte x, Byte y) {
        return (byte)(x - y);
    }

    public Byte mul(Byte x, Byte y) {
        return (byte)(x * y);
    }

    public Byte max(Byte x, Byte y) {
        return x < y ? y : x;
    }

    public Byte min(Byte x, Byte y) {
        return x < y ? x : y;
    }

    public Byte div(Byte x, Byte y) throws BadOperation {
        if (y == 0) {
            throw new BadOperation("Division By Zero");
        } else {
            return (byte)(x / y);
        }
    }

    public Byte neg(Byte x) {
        return (byte)(-x);
    }

    public Byte abs(Byte x) {
        return (byte)Math.abs(x);
    }

    public Byte mod(Byte x, Byte y) throws BadOperation {
        if (y == 0) {
            throw new BadOperation("Module By Zero");
        } else {
            return (byte)(x % y);
        }
    }

    public Byte sqr(Byte x) throws Overflow {
        return this.mul(x, x);
    }
}