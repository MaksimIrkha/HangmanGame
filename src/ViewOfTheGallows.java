
import java.util.Set;

public class ViewOfTheGallows {
    private static final String[] GallowsPics = {
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",

            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========="
    };

    public void displayWord(String wordToGuess, Set<Character>guessedLetters){
        StringBuilder word = new StringBuilder();
        for(char c: wordToGuess.toCharArray()){
            if(guessedLetters.contains(c)){
                word.append(c);
            }
            else {
                word.append("-");
            }
            word.append(" ");
        }
        System.out.println(word.toString());
    }

    public void displayGallows(int countAttempts){
        System.out.println(GallowsPics[GallowsPics.length - countAttempts - 1]);
    }
    public void displayErrorCount(int errorCount) {
        System.out.println("Количество ошибок: " + errorCount);
    }
    public void displayGuessedLetters(Set<Character>guessedLetters){
        StringBuilder stringBuilder = new StringBuilder("Угаданные буквы : ");
        for(char c : guessedLetters){
            stringBuilder.append(c);
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString());
    }


    public void displayIncorrectLetters(Set<Character> incorrectLetters) {
        StringBuilder sb = new StringBuilder("Неправильные буквы: ");
        for (char c : incorrectLetters) {
            sb.append(c);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
    public void showGallows(){
        System.out.println(GallowsPics[GallowsPics.length - 1]);
    }
}
