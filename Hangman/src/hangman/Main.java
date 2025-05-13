package hangman;

import java.util.Locale;
import java.util.Scanner;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args) {
    	while (true) {
            System.out.println("Start new game(S) or exit(E)?");
            char select = readInput();
            if (select == 'S') {
            	Hangman.startGame();
            } else if (select == 'E') {
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Incorrect enter");
            }
    	}
    }
    
    static char readInput() {
        return scanner.nextLine().toUpperCase(Locale.ROOT).charAt(0);
    }
}
