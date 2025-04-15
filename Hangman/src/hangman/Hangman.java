package hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private final int maxTries = 20;
    private boolean[] openIndexes;
    private String guessedWord;
    private GameState state = GameState.NOT_STARTED;
    private int numTries = 0;

    public void startGame() {
        generateWord();
        System.out.println("The word is guessed.");
        showProgress();

        Scanner scanner = new Scanner(System.in);
        while (numTries < maxTries) {
            System.out.print("Enter a letter: ");
            String input = scanner.nextLine().toLowerCase();
            if (input.isEmpty()) continue;

            char guessedLetter = input.charAt(0);
            numTries++;

            for (int i = 0; i < guessedWord.length(); i++) {
                if (guessedWord.charAt(i) == guessedLetter) {
                    openIndexes[i] = true;
                }
            }

            showProgress();

            if (checkWin()) {
                state = GameState.WON;
                break;
            }
        }

        if (state != GameState.WON) {
            state = GameState.LOSS;
        }

        System.out.println("You " + state + "! The word was: " + guessedWord);
    }

    private void showProgress() {
        for (int i = 0; i < guessedWord.length(); i++) {
            if (!openIndexes[i]) {
                System.out.print("_");
            } else {
                System.out.print(guessedWord.charAt(i));
            }
        }
        System.out.println("\nNumber of tries = " + numTries + "\n");
    }

    private boolean checkWin() {
        for (boolean isOpen : openIndexes) {
            if (!isOpen) return false;
        }
        return true;
    }

    private void generateWord() {
        try {
            List<String> words = Files.readAllLines(Paths.get("Dictionary/WordsStockRus.txt"));
            Random random = new Random();
            guessedWord = words.get(random.nextInt(words.size())).toLowerCase();
            openIndexes = new boolean[guessedWord.length()];
            state = GameState.IN_PROGRESS;
        } catch (IOException e) {
            System.out.println("Error reading words file: " + e.getMessage());
            System.exit(1);
        }
    }

}
