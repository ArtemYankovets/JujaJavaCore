package ua.com.juja.UnitTest_Suite;

import org.junit.Test;
import ua.com.juja.UnitTest_TDD_TestableDesign.ArabicToRomanNumberConverter;

import static org.junit.Assert.assertEquals;

public class Test_01 {
    private String convertToRoman(int arabicNumber) {
        ArabicToRomanNumberConverter converter = new ArabicToRomanNumberConverter();
        return converter.convert(arabicNumber);
    }

    @Test
    public void Convert_0_To_EmptyString(){
        String romanNumber = convertToRoman(0);
        assertEquals("", romanNumber);
    }
}
