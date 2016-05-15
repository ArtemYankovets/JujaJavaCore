package ua.com.juja.overriding;

abstract class App {
    public abstract void f();
    public static void main(String[] args) {
        g(null);
    }
    private static void g(Object ref) {
        App app = (App) ref;
    }
}