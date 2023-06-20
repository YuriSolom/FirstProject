package Calculator;

public class Check {
    private Check() {
    }

    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((!Character.isDigit(c) && c != '-')
                    || (chars.length == 1 && c == '-')) {
                return false;
            }
        }
        return true;
    }
}
