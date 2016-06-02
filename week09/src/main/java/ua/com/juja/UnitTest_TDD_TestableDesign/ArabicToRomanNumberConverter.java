package ua.com.juja.UnitTest_TDD_TestableDesign;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ArabicToRomanNumberConverter {

    private List<Pair<Integer, String>> map;

    public ArabicToRomanNumberConverter() {
        map = new ArrayList<>();
        map.add(new Pair<>(1000, "M"));
        map.add(new Pair<>(500, "D"));
        map.add(new Pair<>(100, "C"));
        map.add(new Pair<>(50, "L"));
        map.add(new Pair<>(10, "X"));
        map.add(new Pair<>(5, "V"));
        map.add(new Pair<>(1, "I"));
    }

    public String convert(int arabicNumber) {
        boolean noNumber = arabicNumber == 0;
        if (noNumber)
            return getDefaultRomanNumber();

        String romanNumber = getRoughtRomanNumber(arabicNumber);

        for (int i = 3; i < romanNumber.length(); i++) {
            if (romanNumber.charAt(i - 3) == romanNumber.charAt(i - 2) &&
                    romanNumber.charAt(i - 2) == romanNumber.charAt(i - 1) &&
                    romanNumber.charAt(i - 1) == romanNumber.charAt(i)) {


                String nextRomanNumber = romanNumber.substring(i - 1, i);
                String figure = nextRomanNumber;
                for (Pair<Integer, String> digit : map) {
                    if (nextRomanNumber.equals(digit.getValue())) {
                        nextRomanNumber = figure;
                    }
                    figure = digit.getValue();
                }

                romanNumber = romanNumber.substring(0, i - 2) + nextRomanNumber + romanNumber.substring(i + 1);
            }

        }

        return romanNumber;
    }

    private String getRoughtRomanNumber(int arabicNumber) {
        String romanNumber = "";
        for (Pair<Integer, String> digit : map) {
            while (arabicNumber >= digit.getKey()) {
                romanNumber += digit.getValue();
                arabicNumber -= digit.getKey();
            }
        }
        return romanNumber;
    }

    private String getDefaultRomanNumber() {
        return "";
    }
}
