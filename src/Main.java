import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        GameLogic gameLogic;
        GallowsInputOutput gi = new GallowsInputOutput();
        boolean playAgain;

        do {
            gameLogic = new GameLogic(dictionary.getRandomWord());

            while (!gameLogic.isGameOver()) {
                gameLogic.run();
            }

            gameLogic.resetGame();


            gi.printMessage("Хотите сыграть еще раз? (Д - Да/ Н - Нет): ");
            char response;

            do {
                response = gi.readLetter();
                if (response == 'Д') {
                    playAgain = true;
                    break;
                } else if (response == 'Н') {
                    playAgain = false;
                    break;
                } else {
                    gi.printMessage("Некорректный ответ, попробуйте еще раз.");
                }
            } while (true);
        } while (playAgain);
    }
}