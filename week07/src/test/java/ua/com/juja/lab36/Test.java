package ua.com.juja.lab36;

import java.math.BigInteger;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        BigInteger[] x = {
                new BigInteger("1"),
                new BigInteger("1"),
        };
        BigInteger[] y = {
                new BigInteger("1"),
        };

        BigInteger[] expected = {
                new BigInteger("1"),
                new BigInteger("1"),
        };
        BigInteger[] actual = PolyUtils.mul(x, y);

        if (!Arrays.equals(actual, expected)) {
            throw new AssertionError(Arrays.toString(actual));
        }

        System.out.print("OK");
    }
}
