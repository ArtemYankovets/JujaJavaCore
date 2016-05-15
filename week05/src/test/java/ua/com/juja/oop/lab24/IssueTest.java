package ua.com.juja.oop.lab24;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IssueTest {

    @Test
    public void test(){
        String testNameBook = "TestNameBook";
        String testAuthorBook = "TestBookAuthor";
        int countPages = 100;
        String expectedBookPrint = "Book{name=TestNameBook,countPages=100,author=TestBookAuthor}";

        Issue book = new Book(testNameBook, countPages, testAuthorBook);

        String actualBookPrint = book.toPrint();

        //check
        if (actualBookPrint == null)
            throw new AssertionError("Result cannot be null");


        assertEquals(expectedBookPrint, actualBookPrint);
    }

}
