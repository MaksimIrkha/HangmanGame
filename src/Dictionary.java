import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private static final String DEFAULT_FILENAME = "recources/Dictionary.txt";

    private List<String> wordsList;
    private String[] words;
    private final String fileName;

    public Dictionary() throws IOException {
        this(DEFAULT_FILENAME);
    }

    public Dictionary(String fileName) throws IOException {
        this.fileName = fileName;
        loadListWordsFromFile();
        words = wordsList.toArray(new String[0]);
    }

    private void loadListWordsFromFile() throws IOException {
        File file = new File(fileName);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            wordsList = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    wordsList.add(line);
                }
            }
        }
    }


    public String getRandomWord() {
        int maxLength = 7;
        int minLength = 5;
        Random random = new Random();
        String word;
        List<String> candidateWords = new ArrayList<>();
        for (String w : wordsList) {
            int length = w.length();
            if (length >= minLength && length <= maxLength) {
                candidateWords.add(w);
            }
        }
        if (candidateWords.isEmpty()) {
            int index = random.nextInt(wordsList.size());
            word = wordsList.get(index);
        } else {
            int index = random.nextInt(candidateWords.size());
            word = candidateWords.get(index);
        }
        return word;
    }
}


