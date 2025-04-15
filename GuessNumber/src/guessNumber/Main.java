package guessNumber;

public class Main {
	public static void main(String[] args) {
		
        GuessNumber game = new GuessNumber(100, 5, Players.COMPUTER, Players.HUMAN);
        game.gameBegin();
	}

}
