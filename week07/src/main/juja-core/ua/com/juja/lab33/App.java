package ua.com.juja.lab33;

import java.math.BigInteger;

public class App {
    public static void main(String[] args) {
        BigInteger a = BigInteger.valueOf(256);
        BigInteger b = BigInteger.valueOf(100);
        BigInteger z = a.add(b);
        System.out.println(z);
    }
}
