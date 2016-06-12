package ua.com.juja.UnitTest_Suite;

import org.junit.Test;
import ua.com.juja.UnitTest_TDD_TestableDesign.ArabicToRomanNumberConverter;

import static org.junit.Assert.assertEquals;

public class Test_02 {
    private String convertToRoman(int arabicNumber) {
        ArabicToRomanNumberConverter converter = new ArabicToRomanNumberConverter();
        return converter.convert(arabicNumber);
    }

    @Test
    public void Convert_3_To_III(){
        String romanNumber = convertToRoman(3);
        assertEquals("III", romanNumber);
    }
}
