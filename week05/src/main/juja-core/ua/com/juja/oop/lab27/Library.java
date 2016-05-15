package ua.com.juja.oop.lab27;

public class Library {

    public String getIssueWithCountPagesMoreN(Issue[] catalog, int barrierCountPages) {
        String result = "";
        if (catalog.length != 0){
            for (int i = 0; i < catalog.length; i++) {
                result += catalog[i].getCountPages() > barrierCountPages ? catalog[i].toPrint() : "";
                }
            }
        return result;
    }
}
