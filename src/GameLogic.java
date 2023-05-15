
import java.util.HashSet;
import java.util.Set;

public class GameLogic {


    private static final int MAX_ATTEMPTS = 6;
    GallowsInputOutput gallowsInputOutput;
    private String secretWord;
    private String hiddenWord;
    private int attemptsLeft;
    private Set<Character> guessedLetters;
    private Set<Character> incorrectLetters;
    private ViewOfTheGallows view;


    private int errorsCount = 0;

    public GameLogic(String secretWord) {
        this.gallowsInputOutput = new GallowsInputOutput();
        this.secretWord = secretWord.toUpperCase();
        this.attemptsLeft = MAX_ATTEMPTS;
        this.hiddenWord = generateHiddenWord(secretWord.length());
        this.guessedLetters = new HashSet<>();
        this.view = new ViewOfTheGallows();
        this.incorrectLetters = new HashSet<>();
    }

    private String generateHiddenWord(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("_");
        }
        return sb.toString();
    }

    public boolean guess(char letter) {
        boolean isCorrect = false;
        letter = Character.toUpperCase(letter);
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                hiddenWord = hiddenWord.substring(0, i) + letter + hiddenWord.substring(i + 1);
                isCorrect = true;
            }
        }
        if (isCorrect) {
            guessedLetters.add(letter);
        } else {
            errorsCount++;
            attemptsLeft--;
            incorrectLetters.add(letter);
        }
        return isCorrect;
    }
    public boolean isWordGuessed() {
        return secretWord.equals(hiddenWord);
    }

    public boolean isGameOver() {
        return attemptsLeft == 0;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }
    public void resetGame() {
        attemptsLeft = MAX_ATTEMPTS;
        guessedLetters.clear();
        incorrectLetters.clear();
        errorsCount = 0;
        hiddenWord = generateHiddenWord(secretWord.length());

    }




    public void play() {
        while (!isGameOver()) {
            view.displayGallows(getAttemptsLeft());
            view.displayWord(getHiddenWord(), guessedLetters);
            view.displayGuessedLetters(guessedLetters);
            view.displayIncorrectLetters(incorrectLetters);
            view.displayErrorCount(errorsCount);
            char letter = gallowsInputOutput.readLetter();
            if (guess(letter)) {
                if (isWordGuessed()) {
                    view.displayWord(getHiddenWord(), guessedLetters);
                    gallowsInputOutput.printMessage("Поздравляем! Вы выиграли!");
                    System.out.println();
                    return;
                }
            } else {
                gallowsInputOutput.printMessage("Неправильно! Попробуйте еще раз.");
            }
        }
        view.showGallows();
        gallowsInputOutput.printMessage("Увы, вы проиграли. Загаданное слово было: " + getSecretWord());
        System.out.println();

    }
    public void run() {
        GallowsInputOutput gi = new GallowsInputOutput();
        gi.printMessage("Добро пожаловать в игру Виселица!");
        gi.printMessage("Нажмите Н, чтобы начать новую игру или В, чтобы выйти.");

        char response;
        do {
            response = gi.readLetter();
            if (response == 'Н') {
                play();
                return;
            } else if (response == 'В') {
                gi.printMessage("До свидания!");
                return;
            } else {
                gi.printMessage("Некорректный ответ, попробуйте еще раз.");
            }
        } while (true);
    }
}