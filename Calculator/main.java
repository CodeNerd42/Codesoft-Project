import java.util.Scanner;

public class Calculator {
    public static int fact(int n) {
        if (n <= 1)
            return 1;
        return n * fact(n - 1);
    }

    public static int nPr(int n, int r) {
        return fact(n) / fact(n - r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, num1, num2, i;
        while (true) {
            System.out.println("\n1. ADD");
            System.out.println("2. SUBTRACT");
            System.out.println("3. MULTIPLY");
            System.out.println("4. DIVIDE (get quotient and remainder)");
            System.out.println("5. SQUARE ROOT");
            System.out.println("6. POWER(a number to power other number)");
            System.out.println("7. LCM");
            System.out.println("8. HCF");
            System.out.println("9. FACTORIAL");
            System.out.println("10. FACTORS");
            System.out.println("11. nPr");
            System.out.println("12. EXIT");
            System.out.print("\nEnter your choice : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter the two numbers");
                    num1 = scanner.nextInt();
                    num2 = scanner.nextInt();
                    System.out.println("\nSum = " + (num1 + num2));
                    break;

                case 2:
                    System.out.println("\nEnter the two numbers");
                    num1 = scanner.nextInt();
                    num2 = scanner.nextInt();
                    System.out.println("\nDifference = " + (num1 - num2));
                    break;

                case 3:
                    System.out.println("\nEnter the two numbers");
                    num1 = scanner.nextInt();
                    num2 = scanner.nextInt();
                    System.out.println("\nProduct = " + (num1 * num2));
                    break;

                case 4:
                    System.out.println("\nEnter the two numbers");
                    num1 = scanner.nextInt();
                    num2 = scanner.nextInt();
                    System.out.println("\nQuotient = " + (num1 / num2));
                    System.out.println("Remainder = " + (num1 % num2));
                    break;

                case 5:
                    System.out.print("\nEnter the number : ");
                    num1 = scanner.nextInt();
                    System.out.println("\nSquare root = " + Math.sqrt(num1));
                    break;

                case 6:
                    System.out.print("\nEnter the number : ");
                    num1 = scanner.nextInt();
                    System.out.print("Enter its power : ");
                    num2 = scanner.nextInt();
                    System.out.println(num1 + " to the power " + num2 + " = " + Math.pow(num1, num2));
                    break;

                case 7:
                    System.out.println("\nEnter the numbers");
                    num1 = scanner.nextInt();
                    num2 = scanner.nextInt();
                    int maximum = (num1 > num2) ? num1 : num2;
                    do {
                        if (maximum % num1 == 0 && maximum % num2 == 0) {
                            System.out.println("LCM = " + maximum);
                            break;
                        } else
                            ++maximum;
                    } while (true);
                    break;

                case 8:
                    System.out.println("\nEnter the numbers");
                    num1 = scanner.nextInt();
                    num2 = scanner.nextInt();
                    while (num1 != num2) {
                        if (num1 > num2)
                            num1 -= num2;
                        else
                            num2 -= num1;
                    }
                    System.out.println("HCF = " + num1);
                    break;

                case 9:
                    int ans = 1;
                    System.out.print("\nEnter the number : ");
                    num1 = scanner.nextInt();
                    for (i = 1; i <= num1; i++) {
                        ans = ans * i;
                    }
                    System.out.println("\nFactorial of " + num1 + " = " + ans);
                    break;

                case 10:
                    System.out.print("\nEnter the number : ");
                    num1 = scanner.nextInt();
                    System.out.print("Factors are : ");
                    for (i = 1; i <= num1; i++) {
                        while (num1 % i == 0) {
                            System.out.print(i + "  ");
                            i++;
                        }
                    }
                    System.out.println();
                    break;

                case 11:
                    System.out.print("\nEnter the number : ");
                    num1 = scanner.nextInt();
                    System.out.print("Enter the r : ");
                    num2 = scanner.nextInt();
                    System.out.println(num1 + "P" + num2 + " = " + nPr(num1, num2));
                    break;

                case 12:
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nINVALID CHOICE");
            }
        }
    }
}
