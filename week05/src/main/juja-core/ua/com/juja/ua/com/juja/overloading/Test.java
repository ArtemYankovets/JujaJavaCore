package ua.com.juja.ua.com.juja.overloading;

class Parent {
    Parent() {
        System.out.println("Parent()");
    }
    Parent(int i) {
        System.out.println("Parent(int)");
    }
}
class Child extends Parent {
    Child() {
        System.out.println("Child()");
    }
    Child(int i) {
        System.out.println("Child(int)");
    }
}
class Test {
    public static void main(String[] args) {
        new Child(0);
    }
}