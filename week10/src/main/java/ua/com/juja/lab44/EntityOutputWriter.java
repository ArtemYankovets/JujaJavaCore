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
        return "Person{name=" + name + ", age=" + age + "}";
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

    public EntityInputReader(Reader in) {
        this.in = in;
    }

    @Override
    public Person readPerson() throws IOException {
        BufferedReader reader = new BufferedReader(in);
        String line = reader.readLine();
//        String[] parseLine = lineParser(line, 0, '>', '<');
        return new Person(                   lineParser(line, 0, "<name>", "</name>"),
                            Integer.parseInt(lineParser(line, 0, "<age>", "</age>")));
    }


    @Override
    public Point readPoint() throws IOException {
        BufferedReader reader = new BufferedReader(in);
        String line = reader.readLine();
//           012345678                    9
//out.write("<point x=" + point.getX() + " y=" + point.getY() + "></point>n");
        String str = lineParser(line, 0, "x=", " y=");
        return new Point(Integer.parseInt(str),
                         Integer.parseInt(lineParser(line, 0, "y=", "></")));
    }

    private String lineParser(String line, int startPos, String fromSubStr, String toSubStr) {

        String requiredSubstring = null;

        if ((line.contains(fromSubStr)) && (line.contains(toSubStr))) {

            int beginIndex = 0;
            int endIndex = 0;

            while ((requiredSubstring == null) && (startPos < line.length())) {

                int cursor;
                if ((line.charAt(startPos) == fromSubStr.charAt(0))) {

                    //check the first substring
                    cursor = startPos + 1;
                    int i = 1;
                    while ((i < fromSubStr.length()) && (line.charAt(cursor) == fromSubStr.charAt(i))) {
                        i++;
                        cursor++;
                    }

                    if (i == fromSubStr.length()) {
                        startPos = cursor;
                        beginIndex = startPos;

                        while ((line.charAt(startPos) != toSubStr.charAt(0)) && (startPos < line.length())) {
                            startPos++;
                        }

                        cursor = startPos;
                        i = 0;
                        while ((i < toSubStr.length()) && (line.charAt(cursor) == toSubStr.charAt(i))) {
                            i++;
                            cursor++;
                        }
                        if (i == toSubStr.length()) {
                            endIndex = startPos;
                            requiredSubstring = line.substring(beginIndex, endIndex);
                        } else {
                            startPos = cursor;
                        }

                    } else {
                        startPos = cursor;
                    }
                } else {
                    startPos++;
                }
            }
        }
        return requiredSubstring;
    }
}

