package operations;

/**
 * Created by Dmitry Gnatyuk on 01.03.2019.
 */


import exception.BadOperation;
import exception.Constant;
import exception.Overflow;

import java.math.BigInteger;

public class BiIntOp implements Operation<BigInteger> {
    public BiIntOp() {
    }

    public BigInteger parse(String number) throws Constant {
        return new BigInteger(number);
    }

    public BigInteger add(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    public BigInteger sub(BigInteger x, BigInteger y) {
        return x.subtract(y);
    }

    public BigInteger mul(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    public BigInteger max(BigInteger x, BigInteger y) {
        return x.max(y);
    }

    public BigInteger min(BigInteger x, BigInteger y) {
        return x.min(y);
    }

    private void checkZero(BigInteger y) throws BadOperation {
        if (y.equals(BigInteger.ZERO)) {
            throw new BadOperation("Division By Zero");
        }
    }

    public BigInteger div(BigInteger x, BigInteger y) throws BadOperation {
        this.checkZero(y);
        return x.divide(y);
    }

    public BigInteger neg(BigInteger x) {
        return x.negate();
    }

    public BigInteger abs(BigInteger x) {
        return x.abs();
    }

    public BigInteger mod(BigInteger x, BigInteger y) throws BadOperation {
        if (y.compareTo(BigInteger.ZERO) <= 0) {
            throw new BadOperation("Division By Zero");
        } else {
            return x.mod(y);
        }
    }

    public BigInteger sqr(BigInteger x) throws Overflow {
        return this.mul(x, x);
    }
}