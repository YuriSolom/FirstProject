package Calculator;

import java.io.IOException;

public class Calculator {
    StringBuilder s;
    String[] data = {"", "", ""};

    Calculator(StringBuilder s) {
        this.s = s;
    }

    private void pars() throws IOException {
        int dIndex = 0;
        char l;
        boolean minus = true;
        for (int i = 0; i < s.length(); i++) {
            l = s.charAt(i);
            if (minus) {
                if (Character.isDigit(l) || l == '-' || l == 'I' || l == 'V' || l == 'X') {
                    data[dIndex] += l;
                    minus = false;
                } else throw new IOException("Некорректные данные в строке " + s);
            } else if (Character.isDigit(l) || l == 'I' || l == 'V' || l == 'X') {
                data[dIndex] += l;
            } else if (l == '+' || l == '-' || l == '*' || l == '/') {
                if (++dIndex < 2) {
                    data[dIndex] = String.valueOf(l);
                    dIndex++;
                    minus = true;
                } else throw new IOException("Некорректные данные в строке " + s);
            } else throw new IOException("Некорректные данные " + l + " в позиции " + (i + 1));
        }
    }

    public Integer calculate(String a, String b, String oper) {
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        switch (oper) {
            case "+":
                return a1 + b1;
            case "-":
                return a1 - b1;
            case "*":
                return a1 * b1;
            case "/":
                return a1 / b1;
            default:
                return null;
        }
    }

    public String[] getArr() throws IOException {
        pars();
        return data;
    }
}
