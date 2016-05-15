package ua.com.juja.lab35;

import java.math.BigInteger;

public class PolyUtils {

    public static void main(String[] args) {
        BigInteger[] poly = {new BigInteger("10")};
        BigInteger arg = new BigInteger("1");
        BigInteger expected = new BigInteger("10");
        BigInteger actual = PolyUtils.eval(poly, arg);
        System.out.println(actual.toString());

        if (!expected.equals(actual)) {
            throw new AssertionError();
        }

        System.out.print("OK");

    }

    public static BigInteger eval(BigInteger[] poly, BigInteger arg) {
        BigInteger rez = poly[poly.length - 1];
        if (poly.length > 1) {
            for (int i = 0; i < poly.length - 1; i++) {
                BigInteger temp = arg;
                for (int j = 1; j < poly.length - i - 1; j++) {
                    temp = temp.multiply(arg);
                }
                rez = rez.add(poly[i].multiply(temp));
            }
        }
        return rez;
    }
}