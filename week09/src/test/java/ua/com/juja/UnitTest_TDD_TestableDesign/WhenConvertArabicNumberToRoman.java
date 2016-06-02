package ua.com.juja.UnitTest_TDD_TestableDesign;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhenConvertArabicNumberToRoman {

    private String convertToRoman(int arabicNumber) {
        ArabicToRomanNumberConverter converter = new ArabicToRomanNumberConverter();
        return converter.convert(arabicNumber);
    }

    @Test
    public void Convert_0_To_EmptyString(){
        String romanNumber = convertToRoman(0);
        assertEquals("", romanNumber);
    }

    @Test
    public void Convert_1_To_I(){
        String romanNumber = convertToRoman(1);
        assertEquals("I", romanNumber);
    }

    @Test
    public void Convert_2_To_II(){
        String romanNumber = convertToRoman(2);
        assertEquals("II", romanNumber);
    }

    @Test
    public void Convert_3_To_III(){
        String romanNumber = convertToRoman(3);
        assertEquals("III", romanNumber);
    }

    @Test
    public void Convert_5_To_V(){
        String romanNumber = convertToRoman(5);
        assertEquals("V", romanNumber);
    }

    @Test
    public void Convert_6_To_VI(){
        String romanNumber = convertToRoman(6);
        assertEquals("VI", romanNumber);
    }

    @Test
    public void Convert_8_To_VIII(){
        String romanNumber = convertToRoman(8);
        assertEquals("VIII", romanNumber);
    }

    @Test
    public void Convert_4_To_IV(){
        String romanNumber = convertToRoman(4);
        assertEquals("IV", romanNumber);
    }

    @Test
    public void Convert_9_To_IX(){
        String romanNumber = convertToRoman(9);
        assertEquals("IX", romanNumber);
    }

    @Test
    public void Convert_200_To_CC(){
        String romanNumber = convertToRoman(200);
        assertEquals("CC", romanNumber);
    }
}
