package guessNumber;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private final int max;
    private int tries;
    private final Players guessPlayer;
    private final Players playingPlayer;
    private final Scanner scanner = new Scanner(System.in);

    public GuessNumber(int max, int tries, Players guessPlayer, Players playingPlayer) {
        this.max = max;
        this.tries = tries;
        this.guessPlayer = guessPlayer;
        this.playingPlayer = playingPlayer;
    }

    public void gameBegin() {
        if (guessPlayer == Players.COMPUTER) {
            mode1();
        } else {
            mode2();
        }
    }

    private void mode1() {
        Random rand = new Random();
        int guessNum = rand.nextInt(max);
        System.out.println("Компьютер загадал число");
        while (tries > 0) {
            System.out.print("Угадайте число: ");
            int guessed = Integer.parseInt(scanner.nextLine());

            if (guessed < guessNum) {
                System.out.println(guessed + " < x\n");
                tries--;
            } else if (guessed > guessNum) {
                System.out.println(guessed + " > x\n");
                tries--;
            } else {
                System.out.println("Вы выиграли! Загаданное число: " + guessNum);
                return;
            }
        }
        System.out.println("Вы проиграли! Загаданное число: " + guessNum);
    }

    private void mode2() {
        System.out.println("Загадайте число (от 0 до " + max + "):");
        int guessNum;

        while (true) {
            guessNum = Integer.parseInt(scanner.nextLine());
            if (guessNum > 0 && guessNum < this.max) break;
            System.out.println("Неправильное число");
        }

        int min = 0;
        int maxVal = this.max;
        while (tries > 0) {
            int guessed = (min + maxVal) / 2;
            System.out.println("Я думаю, это " + guessed);
            System.out.print("Если я прав — введите y, если нет — n: ");
            char answer = scanner.nextLine().charAt(0);

            if (answer == 'y') {
                System.out.println("Я выиграл! Число: " + guessed);
                return;
            } else if (answer == 'n') {
                System.out.print("Загаданное число больше (>) или меньше (<) моей догадки? ");
                char hint = scanner.nextLine().charAt(0);

                if (hint == '>') {
                    maxVal = guessed;
                } else if (hint == '<') {
                    min = guessed;
                } else {
                    System.out.println("Неверный ввод");
                    return;
                }
                tries--;
            } else {
                System.out.println("Неверный ввод");
                return;
            }
        }

        System.out.println("Я проиграл! Ваше число: " + guessNum);
    }
}

