package romulConverter;

import java.util.HashMap;
import java.util.Map;

public class RomanConverter {

    public static int romanToArabic(String number) {
        Map<Character, Integer> romul = new HashMap<>();
        romul.put('I', 1);
        romul.put('V', 5);
        romul.put('X', 10);
        romul.put('L', 50);
        romul.put('C', 100);
        romul.put('D', 500);
        romul.put('M', 1000);

        int result = 0;

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            if (!romul.containsKey(current)) {
                throw new IllegalArgumentException("Некорректный символ: " + current);
            }

            int currentVal = romul.get(current);
            int nextVal = 0;

            if (i != number.length() - 1) {
                char next = number.charAt(i + 1);
                nextVal = romul.getOrDefault(next, 0);
            }

            if (currentVal >= nextVal) {
                result += currentVal;
            } else {
                result -= currentVal;
            }
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Число должно быть между 1 и 3999");
        }

        StringBuilder roman = new StringBuilder();

        int[] values =    {1000, 900, 500, 400, 100, 90,  50, 40,  10, 9,   5, 4,  1};
        String[] symbols ={"M",  "CM","D", "CD","C", "XC","L","XL","X","IX","V","IV","I"};

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }
}
