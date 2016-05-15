package ua.com.juja.lab36;

import java.math.BigInteger;

public class PolyUtils {

    public static void main(String[] args) {
        BigInteger[] a = new BigInteger[]{
                new BigInteger("10"),
                new BigInteger("0"),
                new BigInteger("1")};
        System.out.println("FIRST is:");
        printBigIntegerArray(a);

        BigInteger[] b = new BigInteger[]{
                new BigInteger("-1"),
                new BigInteger("0")};
        System.out.println("SECOND is:");
        printBigIntegerArray(b);

        BigInteger[] c = mul(a, b);
        System.out.println("REZULT is:");
        printBigIntegerArray(c);
    }

    public static BigInteger[] mul(BigInteger[] x, BigInteger[] y) {

        BigInteger[] rez = new BigInteger[x.length + y.length - 1];
        for (int i = 0; i < rez.length; i++) {
            rez[i] = new BigInteger("0");
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                rez[rez.length - ((x.length - i) + (y.length - j) - 1)] = rez[rez.length - ((x.length - i) + (y.length - j) - 1)].add(x[i].multiply(y[j]));

                System.out.print("[ i=" + i + ", j=" + j + "]: ");
                printBigIntegerArray(rez);
            }
        }
        return rez;
    }

    public static void printBigIntegerArray(BigInteger[] array) {
        System.out.println("\t");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].toString() + "\t");
        }
        System.out.println("");
    }
}