package threeInRow;

public class ThreeInRow {

    public enum State {
        X, O, Empty
    }

    private final State[] board = new State[9];
    private State turn;
    private int numOfTurn;
    private boolean gameEnded;

    public ThreeInRow() {
        resetGame();
    }

    public void resetGame() {
        for (int i = 0; i < board.length; i++) {
            board[i] = State.Empty;
        }
        turn = State.X;
        numOfTurn = 0;
        gameEnded = false;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public State getCurrentPlayer() {
        return turn;
    }

    public State[] getBoard() {
        return board;
    }

    public boolean makeMove(int position) {
        if (position < 1 || position > 9) {
            System.out.println("Некорректный номер клетки!");
            return false;
        }

        int index = position - 1;
        if (board[index] != State.Empty) {
            System.out.println("Клетка уже занята!");
            return false;
        }

        board[index] = turn;
        numOfTurn++;

        if (checkWin()) {
            gameEnded = true;
            System.out.println("🎉 Победил игрок " + turn + "!");
        } else if (numOfTurn == 9) {
            gameEnded = true;
            System.out.println("🤝 Ничья!");
        } else {
            turn = (turn == State.X) ? State.O : State.X;
        }

        return true;
    }

    private boolean checkWin() {
        int[][] wins = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
        };

        for (int[] line : wins) {
            if (board[line[0]] != State.Empty &&
                board[line[0]] == board[line[1]] &&
                board[line[1]] == board[line[2]]) {
                return true;
            }
        }

        return false;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == State.Empty) {
                System.out.print(i + 1);
            } else {
                System.out.print(board[i]);
            }

            if ((i + 1) % 3 == 0) {
                System.out.println();
            } else {
                System.out.print("|");
            }
        }
        System.out.println();
    }
}
