package ua.com.juja.lab34;

import java.math.BigInteger;

public class BigIntegerUtils {

    public static void main(String[] args) {
        System.out.println(toBitStr(new BigInteger("7")));
        System.out.println(toBitStr2());
    }

    public static String toBitStr(BigInteger arg) {
        return arg.toString(2);
    }

    public static String toBitStr2() {
        String s1 = "0011111111101111111111111100101101111100110000001011111000010100";
        String s2 = "0011111111100000110011001100110011001100110011001100110011001100";
        BigInteger bi1, bi2, bi3;
        bi1 = new BigInteger(s1, 2);
        bi2 = new BigInteger(s2, 2);
        bi3 = bi1.xor(bi2);
        String s3 = bi3.toString(2);
        return s3;
    }
}