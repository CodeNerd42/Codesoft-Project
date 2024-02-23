import java.util.Scanner;

public class MineSweeper {
    static char[][] table = new char[10][10];
    static char[][] tableMinePositions = new char[10][10];
    static char symbol;
    static int flagCounter = 0;
    static int minesFlaggedCounter = 0;
    static boolean endGameLose = false;
    static long timeSinceEpoch = System.currentTimeMillis();
    static long gameTime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rules:\nThe player enters 'o', then enters the value of i and j to open cell[i][j].");
        System.out.println("Enter 'f', then enter the value of i and j to place a flag on cell[i][j].\n");

        game();
    }

    static void reveal(int i, int j) {
        if (table[i][j] == '*' && tableMinePositions[i][j] != 'X' && i >= 0 && i < 10 && j >= 0 && j < 10) {
            table[i][j] = tableMinePositions[i][j];

            if (tableMinePositions[i][j] == '0') {
                reveal(i, j - 1);
                reveal(i, j + 1);
                reveal(i - 1, j - 1);
                reveal(i + 1, j - 1);
                reveal(i + 1, j + 1);
                reveal(i - 1, j + 1);
                reveal(i - 1, j);
                reveal(i + 1, j);
            }
        }
    }

    static void placeOrRemoveFlag() {
        Scanner scanner = new Scanner(System.in);
        int i, j;
        do {
            System.out.print("Enter the value of i and j to place or remove flag: ");
            i = scanner.nextInt();
            j = scanner.nextInt();
        } while (i < 0 || i > 9 || j < 0 || j > 9);

        if (table[i][j] == '*') {
            table[i][j] = 'F';
            flagCounter++;
            if (tableMinePositions[i][j] == 'X')
                minesFlaggedCounter++;
        } else if (table[i][j] == 'F') {
            table[i][j] = '*';
            flagCounter--;
            if (tableMinePositions[i][j] == 'X')
                minesFlaggedCounter--;
        }
    }

    static void inputSymbol() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter symbol (o/f): ");
        symbol = scanner.next().charAt(0);
        switch (symbol) {
            case 'o':
                openCell();
                break;
            case 'f':
                placeOrRemoveFlag();
                break;
            default:
                inputSymbol();
                break;
        }
    }

    static void openCell() {
        Scanner scanner = new Scanner(System.in);
        int i, j;
        do {
            System.out.print("Enter the value of i and j to open cell: ");
            i = scanner.nextInt();
            j = scanner.nextInt();
        } while (i < 0 || i > 9 || j < 0 || j > 9);

        if (tableMinePositions[i][j] == 'X') {
            table[i][j] = 'X';
            endGameLose = true;

            for (i = 0; i < 10; i++)
                for (j = 0; j < 10; j++)
                    if (tableMinePositions[i][j] == 'X')
                        table[i][j] = 'X';
        } else
            reveal(i, j);
    }

    static boolean endGameWinCheck() {
        return flagCounter == 10 && minesFlaggedCounter == 10;
    }

    static void game() {
        createTable();
        createMinePositions();

        Scanner scanner = new Scanner(System.in);
        while (!endGameLose && !endGameWinCheck()) {
            gameTime = System.currentTimeMillis();
            printTable(table);
            System.out.println("\nFlags: " + flagCounter);
            System.out.println("Time: " + (gameTime - timeSinceEpoch) + " ms");
            inputSymbol();
        }

        if (endGameLose) {
            printTable(table);
            System.out.println("\nGAME OVER");
        }

        if (endGameWinCheck())
            System.out.println("Time to complete: " + (gameTime - timeSinceEpoch) + " ms");
        System.out.println("\nYOU WIN!");
    }

    static void createMinePositions() {
        int counter = 0;
        while (counter < 10) {
            int i = (int) (Math.random() * 10);
            int j = (int) (Math.random() * 10);
            if (tableMinePositions[i][j] == '0') {
                tableMinePositions[i][j] = 'X';

                cellNumber(i - 1, j);
                cellNumber(i + 1, j);
                cellNumber(i, j - 1);
                cellNumber(i, j + 1);
                cellNumber(i - 1, j - 1);
                cellNumber(i - 1, j + 1);
                cellNumber(i + 1, j - 1);
                cellNumber(i + 1, j + 1);

                counter++;
            }
        }
    }

    static void cellNumber(int i, int j) {
        if (i >= 0 && i < 10 && j >= 0 && j < 10 && tableMinePositions[i][j] != 'X')
            tableMinePositions[i][j]++;
    }

    static void createTable() {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                table[i][j] = '*';
    }

    static void printTable(char[][] arr) {
        System.out.print("    ");
        for (int i = 0; i < 10; i++)
            System.out.printf("%3d", i);
        System.out.println("\n  _______________________________");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%3d|", i);
            for (int j = 0; j < 10; j++)
                System.out.printf("%3c", arr[i][j]);
            System.out.println();
        }
    }
}
