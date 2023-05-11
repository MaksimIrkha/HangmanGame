import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class GallowsInputOutput {
    private Scanner scanner;

    public GallowsInputOutput(){
        scanner = new Scanner(System.in);
    }
    public char readLetter() {
        System.out.println("Введите букву: ");
        String input = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            input = br.readLine().toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (input.trim().length() != 1 || !Character.isLetter(input.trim().charAt(0))) {
            System.out.println("Неверный ввод. Введите букву: ");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
                input = br.readLine().toUpperCase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return input.charAt(0);
    }
    public void printMessage(String message){
        System.out.println(message);
    }
}
