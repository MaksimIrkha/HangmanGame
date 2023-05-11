import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        GameLogic gameLogic = new GameLogic(dictionary.getRandomWord());
        gameLogic.run();
    }
}
