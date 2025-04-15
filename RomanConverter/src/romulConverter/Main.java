package romulConverter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите римское число:");
        String romanNumber = scanner.nextLine().toUpperCase();
        try {
            int arabicResult = RomanConverter.romanToArabic(romanNumber);
            System.out.println("Римское число " + romanNumber + " в арабской системе: " + arabicResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("Введите арабское число:");
        int arabicNumber = scanner.nextInt();
        try {
            String romanResult = RomanConverter.arabicToRoman(arabicNumber);
            System.out.println("Арабское число " + arabicNumber + " в римской системе: " + romanResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}


