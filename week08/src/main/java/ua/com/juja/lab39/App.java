package ua.com.juja.lab39;

public class App {
    public static void main(String[] args) throws Throwable {
        A newImpl = new B();

        String str = newImpl.create("Hello world!");

        System.out.println(str);
    }
}

interface A {
    public String create(String s) throws Throwable;
}

class B implements A{

    @Override
    public String create(String s){
        return s + " HI";
    }
}