package ua.com.juja.Trial;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) throws UnsupportedOperationException{
        String juja = "ДжуДжа";
        System.out.println(getDefaultCharset());
        Map<String, Charset> allCharsets = Charset.availableCharsets();
        Set<String> charsetsName = allCharsets.keySet();

        System.out.println(charsetsName);
        System.out.println(charsetsName.size());

        Charset ascii = java.nio.charset.StandardCharsets.US_ASCII;

    }

    private static String getDefaultCharset() {
        Charset defaultCharset = Charset.defaultCharset();
        return defaultCharset.displayName();
    }

}
