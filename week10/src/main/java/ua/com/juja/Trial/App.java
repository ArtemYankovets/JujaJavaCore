package ua.com.juja.Trial;

import java.nio.charset.Charset;

public class App {
    public static void main(String[] args) {
        String juja = "ДжуДжа";
        System.out.println(getDefaultCharset());
    }

    private static String getDefaultCharset() {
        Charset defaultCharset = Charset.defaultCharset();
        return defaultCharset.displayName();
    }

}
