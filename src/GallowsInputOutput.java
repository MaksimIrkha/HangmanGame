import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class GallowsInputOutput {
    private Scanner scanner;

    private BufferedReader reader;

    public GallowsInputOutput(){
        scanner = new Scanner(System.in);
        reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    }
    public char readLetter() {

        String input;
        do {
            System.out.println("Введите букву: ");
            input = "";
        try {
            input = reader.readLine().toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (input.trim().length() != 1 || !Character.isLetter(input.trim().charAt(0))) {
            System.out.println("Неверный ввод. Введите букву: ");
        }
        }
        while (input.trim().length() != 1 || !Character.isLetter(input.trim().charAt(0)));

        return input.charAt(0);
    }
    public void printMessage(String message){
        System.out.println(message);
    }
}
