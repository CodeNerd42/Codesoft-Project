import java.util.Scanner;

public class TicTacToe {
    static char[][] matrix = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    static String player1 = "", player2 = "";
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("\n1. Start the game.");
            System.out.println("2. How to play?");
            System.out.println("3. Quit the game.");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    startGame(scanner);
                    break;
                case 2:
                    showInstructions(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void startGame(Scanner scanner) {
        scanner.nextLine(); // Consume newline character
        System.out.print("\nEnter player's name who is choosing 'X': ");
        player1 = scanner.nextLine();
        System.out.println("Welcome " + player1 + "! Your icon is 'X'.");
        System.out.print("\nEnter player's name who is choosing 'O': ");
        player2 = scanner.nextLine();
        System.out.println("Welcome " + player2 + "! Your icon is 'O'.");
        System.out.println("\nPress Enter to start the game...");
        scanner.nextLine(); // Wait for Enter key press
        while (true) {
            count = 0;
            clearMatrix();
            box();
            input(scanner);
            System.out.println("\n\n\n\t\t\t\tGAME OVER");
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine(); // Wait for Enter key press
        }
    }

    static void clearMatrix() {
        matrix = new char[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    }

    static void box() {
        for (int i = 0; i < 3; i++) {
            System.out.println("|| " + matrix[i][0] + " || " + matrix[i][1] + " || " + matrix[i][2] + " ||");
            System.out.println("||---||---||---||");
        }
    }

    static char win() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) {
                return matrix[i][0];
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]) {
                return matrix[0][i];
            }
        }
        // Check diagonals
        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) {
            return matrix[0][0];
        }
        if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]) {
            return matrix[0][2];
        }
        return '$'; // No winner yet
    }

    static void input(Scanner scanner) {
        char a;
        while (true) {
            System.out.println("\n\nTurn for " + player1 + "...");
            count++;
            a = scanner.next().charAt(0);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (a == matrix[i][j]) {
                        matrix[i][j] = (count % 2 == 0) ? 'O' : 'X';
                    }
                }
            }
            clearConsole();
            box();
            char result = win();
            if (result == 'X') {
                System.out.println("\n\nCongratulations " + player1 + "! You have won the game!!!!");
                count = 0;
                break;
            } else if (result == '$' && count == 9) {
                System.out.println("\n\n\n\t\rIt's a tie!!!!!");
                count = 0;
                break;
            }
            System.out.println("\n\nTurn for " + player2 + "...");
            count++;
            a = scanner.next().charAt(0);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (a == matrix[i][j]) {
                        matrix[i][j] = (count % 2 == 0) ? 'O' : 'X';
                    }
                }
            }
            clearConsole();
            box();
            result = win();
            if (result == 'O') {
                System.out.println("\n\n\n\t\tCongratulations " + player2 + "! You have won the game!!!!");
                break;
            }
        }
    }

    static void showInstructions(Scanner scanner) {
        System.out.println("\n\n\t\t\t\t\t:_INSTRUCTIONS:_");
        System.out.println("\n\tThe game is played on a grid that's 3 squares by 3 squares.");
        System.out.println("\tYou are X, your friend is O. Players take turns putting their marks in empty squares.");
        System.out.println("\tThe first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.");
        System.out.println("\tWhen all 9 squares are full, the game is over.");
        System.out.print("\nPress Enter to go back to the main menu...");
        scanner.nextLine(); // Wait for Enter key press
    }

    static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Handle exceptions
        }
    }
}
