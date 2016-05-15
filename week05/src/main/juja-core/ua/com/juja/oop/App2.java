package ua.com.juja.oop;

public class App2 {
    public static void main(String[] args) {
        Outer ref = new Outer();
    }
}
class Outer {
    class Inner {}
    static class Nested {}
}