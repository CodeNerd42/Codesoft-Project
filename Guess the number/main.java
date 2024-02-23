import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number, guess, numberOfGuess = 0; // number will contain random number chosen by computer.
                                              // guess will contain the number guessed by the user.
                                              // numberOfGuess will count the number of times user has taken to guess the correct number.

        System.out.println("Guess the number between 1 and 100");

        number = (int) (Math.random() * 100); // Generating random number between 0 and 99

        do {
            guess = scanner.nextInt();

            if (guess > number) {
                System.out.println("Lower number please!");
                numberOfGuess++;
            } else if (number > guess) {
                System.out.println("Higher number please!");
                numberOfGuess++;
            } else
                System.out.println("You guessed the number in " + numberOfGuess + " attempts!");
        } while (guess != number);
    }
}
