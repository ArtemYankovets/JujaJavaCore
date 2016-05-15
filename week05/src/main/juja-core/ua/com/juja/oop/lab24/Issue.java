package ua.com.juja.oop.lab24;

/**
 * LAB 24
 */

public class Issue {
    private String name;
    private int countPages;

    public Issue(String name, int countPages) {
        this.name = name;
        this.countPages = countPages;
    }

    public String toPrint() {
        return "name=" + name +
                ",countPages=" + countPages;
    }
}

class Book extends Issue {
    private String authorBook;

    public Book(String name, int countPages, String authorBook) {
        super(name, countPages);
        this.authorBook = authorBook == null ? "" : authorBook;
    }

    @Override
    public String toPrint() {
        return "Book{" + super.toPrint() + ",author=" + authorBook + "}";
    }
}