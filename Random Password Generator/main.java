import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("How long should the password be?");
        int n = scanner.nextInt();
        
        String numbers = "1234567890";
        String letters = "abcdefghijklmnoqprstuvwyzx";
        String capitalLetters = "ABCDEFGHIJKLMNOQPRSTUYWVZX";
        String symbols = "!@#$^&*?";
        
        StringBuilder password = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int randomizer = random.nextInt(4) + 1;
            switch (randomizer) {
                case 1:
                    password.append(numbers.charAt(random.nextInt(numbers.length())));
                    break;
                case 2:
                    password.append(symbols.charAt(random.nextInt(symbols.length())));
                    break;
                case 3:
                    password.append(capitalLetters.charAt(random.nextInt(capitalLetters.length())));
                    break;
                case 4:
                    password.append(letters.charAt(random.nextInt(letters.length())));
                    break;
            }
            System.out.print(password.charAt(i));
        }
        scanner.close();
    }
}
