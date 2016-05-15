package ua.com.juja.lab33;

import java.math.BigInteger;

public class FractionUtils {

    public static void main(String[] args) {
        BigInteger[] a = new BigInteger[]{new BigInteger("2"), new BigInteger("3")};
        BigInteger[] b = new BigInteger[]{new BigInteger("1"), new BigInteger("3")};
        BigInteger[] c = sum(a, b);

        System.out.println(a[0].toString() + "/" + a[1].toString());
        System.out.println(b[0].toString() + "/" + b[1].toString());
        System.out.println(c[0].toString() + "/" + c[1].toString());
    }

    public static BigInteger[] sum(BigInteger[] x, BigInteger[] y) {
        BigInteger[] z = new BigInteger[2];

        if ((x[1].compareTo(y[1])) == 0){
            z[0] = x[0].add(y[0]);
            z[1] = x[1];
        } else {
            z[0] = (x[0].multiply(y[1])).add(x[1].multiply(y[0]));
            z[1] = x[1].multiply(y[1]);
        }

        BigInteger gcd = z[0].gcd(z[1]);
        if (gcd.compareTo(new BigInteger("0")) == 1) {
            z[0] = z[0].divide(gcd);
            z[1] = z[1].divide(gcd);
        }

        return z;
    }
}