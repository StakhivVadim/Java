package chinaGame;

//Играют два игрока.  Есть 10 палочек (по умолчанию). Игроки по очереди берут от одной до трёх палочек. Играют до тех пор пока не закончатся палочки. Тот кто взял последним - тот проиграл.

public class Main {
    public static void main(String[] args) {
        ChinaGame game = new ChinaGame(10);
        game.start();
    }
}
