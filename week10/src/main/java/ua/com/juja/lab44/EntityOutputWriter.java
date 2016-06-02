package ua.com.juja.lab44;

import java.io.*;

public class EntityOutputWriter implements EntityOutput {
    private final Writer out;

    public EntityOutputWriter(Writer out) {
        this.out = out;
    }

    public void writePerson(Person person) throws IOException {
        int age = person.getAge();
        String name = person.getName();
        out.write("<person>n");
        out.write("    <age>" + age + "</age>n");
        out.write("    <name>" + name + "</name>n");
        out.write("</person>n");
        out.flush();
    }

    @Override
    public void writePoint(Point point) throws IOException {
        out.write("<point x=" + point.getX() + " y=" + point.getY() + "></point>n");
        out.flush();
    }
}

interface EntityInput {
    public Person readPerson() throws IOException;

    public Point readPoint() throws IOException;
}

interface EntityOutput {
    public void writePerson(Person person) throws IOException;

    public void writePoint(Point point) throws IOException;
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name=" + name  + ", age=" + age + "}";
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        if (x < 0 || 15 < x) {
            throw new IllegalArgumentException();
        }
        if (y < 0 || 15 < y) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" + x + ", " + y + "}";
    }
}

class EntityInputReader implements EntityInput {
    private Reader in;

    /*BODY*/

    @Override
    public Person readPerson() throws IOException {
        return null;
    }

    @Override
    public Point readPoint() throws IOException {
        return null;
    }




}

