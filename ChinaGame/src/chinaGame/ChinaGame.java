package chinaGame;

import java.util.Scanner;
import java.util.Random;

public class ChinaGame {
    private int numOfSticks;
    private int chosenSticks;
    private GameStatus status = GameStatus.NotStarted;
    private TurnPlayer turn;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public ChinaGame(int numOfSticks) {
        this.numOfSticks = numOfSticks;
    }

    public void start() {
        while (true) {
            System.out.println("Choose who is 1st player. Enter 'me' or 'comp':");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("me")) {
                turn = TurnPlayer.Player;
                break;
            } else if (input.equalsIgnoreCase("comp")) {
                turn = TurnPlayer.Computer;
                break;
            } else {
                System.out.println("Incorrect input. Try again.");
            }
        }
        status = GameStatus.InGame;
        System.out.println("Number of sticks = " + numOfSticks);
        playGame();
    }

    private void playGame() {
        while (status == GameStatus.InGame) {
            if (turn == TurnPlayer.Player) {
                playerTurn();
            } else {
                computerTurn();
            }
        }
    }

    private void playerTurn() {
        System.out.println("Enter number of sticks you want to take (1-3):");

        try {
            chosenSticks = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
            return;
        }

        while (chosenSticks < 1 || chosenSticks > 3 || chosenSticks > numOfSticks) {
            System.out.println("Incorrect number, try again:");
            try {
                chosenSticks = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
                return;
            }
        }

        numOfSticks -= chosenSticks;
        System.out.println("Number of sticks = " + numOfSticks);

        if (numOfSticks == 0) {
            status = GameStatus.Win;
            System.out.println("You won!");
        } else {
            turn = TurnPlayer.Computer;
        }
    }

    private void computerTurn() {
        chosenSticks = chooseSticks(numOfSticks);
        System.out.println("My turn. I take " + chosenSticks + " sticks.");
        numOfSticks -= chosenSticks;
        System.out.println("Number of sticks = " + numOfSticks);

        if (numOfSticks == 0) {
            status = GameStatus.Loss;
            System.out.println("I won!");
        } else {
            turn = TurnPlayer.Player;
        }
    }
    
    private int chooseSticks(int remainingSticks) {
        int remainder = remainingSticks % 4;
        if (remainder == 0) {
            return random.nextInt(Math.min(3, remainingSticks)) + 1;
        }
        return Math.min(remainder, remainingSticks);
    }
}

