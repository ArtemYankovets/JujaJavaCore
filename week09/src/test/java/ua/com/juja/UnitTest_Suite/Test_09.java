package ua.com.juja.UnitTest_Suite;

import org.junit.Test;
import ua.com.juja.UnitTest_TDD_TestableDesign.ArabicToRomanNumberConverter;

import static org.junit.Assert.assertEquals;

public class Test_09 {
    private String convertToRoman(int arabicNumber) {
        ArabicToRomanNumberConverter converter = new ArabicToRomanNumberConverter();
        return converter.convert(arabicNumber);
    }

    @Test
    public void Convert_9_To_IX(){
        String romanNumber = convertToRoman(9);
        assertEquals("IX", romanNumber);
    }
}
