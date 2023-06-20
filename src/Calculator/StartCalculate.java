package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartCalculate {
    static final String MESS1 = "Числа не соответсвуют условиям!!";
    static final String MESS2 = "Числа вышли из доступного диапазона!!";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];
        System.out.print("Введи операцию с двумя числами(без пробелов) : ");
        Calculator calculator = new Calculator(new StringBuilder(reader.readLine()));
        try {
            arr = calculator.getArr();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (Check.isNumber(arr[0])) {
            if (Check.isNumber(arr[2])) {
                if (Integer.parseInt(arr[0]) > 10 || Integer.parseInt(arr[0]) < 1
                        || Integer.parseInt(arr[2]) > 10 || Integer.parseInt(arr[2]) < 1) {
                    System.out.println(MESS2);
                } else System.out.println(calculator.calculate(arr[0], arr[2], arr[1]));
            } else System.out.println(MESS1);
        } else {
            RomanNum roman = new RomanNum();
            int a, b;
            try {
                a = roman.romanToArabic(arr[0]);
                b = roman.romanToArabic(arr[2]);
                if (a > 10 || a < 1 || b > 10 || b < 1) System.out.println(MESS2);
                else {
                    int res = calculator.calculate(String.valueOf(a), String.valueOf(b), arr[1]);
                    System.out.println(roman.arabicToRoman(res));
                }
            } catch (IOException e) {
                System.out.println(MESS1);
            }
        }
    }
}
