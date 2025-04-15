package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите математическое выражение для вычисления (например, 3 + (2 - 1) * 4 + (6 / 2)):");
            String expression = scanner.nextLine();

            try {
                double result = Calculator.evaluateExpression(expression);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("Ошибка в вычислениях: " + e.getMessage());
            }

            System.out.println("Хотите ввести другое выражение? (да/нет):");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("нет")) {
                break;
            }
        }

        scanner.close();
    }
}


