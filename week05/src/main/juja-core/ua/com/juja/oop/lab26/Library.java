package ua.com.juja.oop.lab26;

public class Library {

    public String printCatalog(Issue[] catalog) {
        String result = "";
        if (catalog.length != 0){
            for (int i = 0; i < catalog.length; i++) {
                result = result + catalog[i].toPrint();
            }
        }
        return result;
    }
}
