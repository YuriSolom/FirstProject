package Calculator;

import java.io.IOException;
import java.util.TreeMap;

public final class RomanNum {
    private final TreeMap<Integer, String> romanMap = new TreeMap<>();

    {
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
    }

    public String arabicToRoman(int num) {
        if (num == 0) {
            return "0";
        }
        int i = romanMap.floorKey(num);
        if (num == i) {
            return romanMap.get(num);
        } else {
            return romanMap.get(i) + arabicToRoman(num - i);
        }
    }

    public int romanToArabic(String numRoman) throws IOException {
        int numArabic = 0;
        int lastNum = 0;
        if (numRoman.toString().equals("")) {
            throw new IOException("Некорректные данные в выражении " + numRoman);
        } else {
            for (int i = numRoman.length() - 1; i >= 0; i--) {
                switch (numRoman.charAt(i)) {
                    case 'I':
                        numArabic = (lastNum > 1) ? (numArabic - 1) : (numArabic + 1);
                        lastNum = 1;
                        break;
                    case 'V':
                        numArabic = (lastNum > 5) ? (numArabic - 5) : (numArabic + 5);
                        lastNum = 5;
                        break;
                    case 'X':
                        numArabic = (lastNum > 10) ? (numArabic - 10) : (numArabic + 10);
                        lastNum = 10;
                        break;
                    case 'L':
                        numArabic = (lastNum > 50) ? (numArabic - 50) : (numArabic + 50);
                        lastNum = 50;
                        break;
                    case 'C':
                        numArabic = (lastNum > 100) ? (numArabic - 100) : (numArabic + 100);
                        lastNum = 100;
                        break;
                    default:
                        throw new IOException("Некорректные данные в выражении " + numRoman);
                }
            }
        }
        return numArabic;
    }
}
