package ua.com.juja.trial_set;

import java.util.NavigableSet;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        NavigableSet<User> users = new TreeSet<>();
        users.add(new User(25, "Mike"));
        users.add(new User(25, "Sara"));
        users.add(new User(26, "Sara"));
        System.out.println(users.iterator().next());
        System.out.println(users);
    }
}
class User implements Comparable<User> {
    public String name;
    public int age;

    User(int age, String name) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + name + ", " + age + "}";
    }

    @Override
    public int compareTo(User that) {
        int result = that.age - this.age;
        if (result != 0) {
            return result;
        } else {
            return this.name.compareTo(that.name);
        }
    }
}