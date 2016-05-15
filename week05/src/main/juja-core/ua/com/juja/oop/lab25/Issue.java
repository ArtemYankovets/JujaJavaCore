package ua.com.juja.oop.lab25;

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
class Journal extends Issue {
    private String yearJournal;
    private String numberJournal;

    public Journal(String name, int countPages, String yearJournal, String numberJournal) {
        super(name, countPages);
        this.yearJournal = yearJournal == null ? "" : yearJournal;
        this.numberJournal = numberJournal == null ? "" : numberJournal;
    }

    @Override
    public String toPrint() {
        return "Journal{" + super.toPrint() + ",year=" + yearJournal + ",number=" + numberJournal + "}";
    }
}