package threeInRow;

import java.util.Scanner;

public class ThreeInRowGame {
    private final Scanner scanner = new Scanner(System.in);
    private final ThreeInRow game = new ThreeInRow();

    public void run() {
        boolean playAgain;

        do {
            game.resetGame();
            playGame();

            System.out.println("Сыграть ещё раз? (y/n): ");
            playAgain = scanner.nextLine().trim().equalsIgnoreCase("y");

        } while (playAgain);

        System.out.println("Спасибо за игру!");
    }

    private void playGame() {
        while (!game.isGameEnded()) {
            game.printBoard();
            System.out.println("Ход игрока " + game.getCurrentPlayer() + ". Введите номер клетки (1-9):");

            try {
                int move = Integer.parseInt(scanner.nextLine());
                game.makeMove(move);
            } catch (NumberFormatException e) {
                System.out.println("Введите число!");
            }
        }

        game.printBoard();
    }
}

