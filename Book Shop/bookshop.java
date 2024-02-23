import java.io.*;
import java.util.Scanner;

class Bookshop {
    public void controlPanel() {
        System.out.println("\n\n\t\t\t\tCONTROL  PANEL");
        System.out.println("\n\n1. ADD BOOK");
        System.out.println("2. DISPLAY BOOKS");
        System.out.println("3. CHECK PARTICULAR BOOK");
        System.out.println("4. UPDATE BOOK");
        System.out.println("5. DELETE BOOK");
        System.out.println("6. EXIT");
    }

    public void addBook() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\n\t\t\t\tADD BOOKS");
            System.out.println("\n\nBook ID : ");
            String b_id = scanner.nextLine();
            System.out.println("\nBook Name : ");
            String b_name = scanner.nextLine();
            System.out.println("\nAuthor Name : ");
            String a_name = scanner.nextLine();
            System.out.println("\nNo. of Books : ");
            int no_copy = Integer.parseInt(scanner.nextLine());
            FileWriter file = new FileWriter("D://book.txt", true);
            file.write(" " + b_id + " " + b_name + " " + a_name + " " + no_copy + "\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBook() {
        try {
            BufferedReader file = new BufferedReader(new FileReader("D://book.txt"));
            String line;
            System.out.println("\n\n\t\t\t\t\tAll BOOKS");
            System.out.println("\n\n\nBook ID\t\tBook\t\tAuthor\t\tNo. of Books\n\n");
            while ((line = file.readLine()) != null) {
                System.out.println(line);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkBook() {
        try {
            Scanner scanner = new Scanner(System.in);
            BufferedReader file = new BufferedReader(new FileReader("D://book.txt"));
            System.out.println("\n\n\t\t\t\tCheck Particular Book");
            System.out.println("\n\nBook ID : ");
            String b_idd = scanner.nextLine();
            String line;
            boolean found = false;
            while ((line = file.readLine()) != null) {
                if (line.contains(b_idd)) {
                    System.out.println(line);
                    found = true;
                    break;
                }
            }
            if (!found)
                System.out.println("\n\nBook ID Not Found...");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateBook() {
        try {
            Scanner scanner = new Scanner(System.in);
            BufferedReader file = new BufferedReader(new FileReader("D://book.txt"));
            BufferedWriter file1 = new BufferedWriter(new FileWriter("D://book1.txt"));
            System.out.println("\n\n\t\t\t\tUpdate Book Record");
            System.out.println("\n\nBook ID : ");
            String b_id = scanner.nextLine();
            String line;
            boolean found = false;
            while ((line = file.readLine()) != null) {
                if (line.contains(b_id)) {
                    System.out.println("Enter New Book Name : ");
                    String b_na = scanner.nextLine();
                    System.out.println("Enter Author Name : ");
                    String a_na = scanner.nextLine();
                    System.out.println("Enter No. of Books : ");
                    int no_co = Integer.parseInt(scanner.nextLine());
                    file1.write(" " + b_id + " " + b_na + " " + a_na + " " + no_co + "\n\n");
                    found = true;
                } else {
                    file1.write(line + "\n\n");
                }
            }
            if (!found)
                System.out.println("\n\nBook ID Not Found...");
            file.close();
            file1.close();
            File oldFile = new File("D://book.txt");
            oldFile.delete();
            File newFile = new File("D://book1.txt");
            newFile.renameTo(oldFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook() {
        try {
            Scanner scanner = new Scanner(System.in);
            BufferedReader file = new BufferedReader(new FileReader("D://book.txt"));
            BufferedWriter file1 = new BufferedWriter(new FileWriter("D://book1.txt"));
            System.out.println("\n\n\t\t\t\tDelete a Book");
            System.out.println("\n\nBook ID : ");
            String b_id = scanner.nextLine();
            String line;
            boolean found = false;
            while ((line = file.readLine()) != null) {
                if (line.contains(b_id)) {
                    System.out.println("\n\n\t\t\t\tDelete a Book");
                    System.out.println("\n\nBook is Deleted Successfully...\n\n");
                    found = true;
                } else {
                    file1.write(line + "\n\n");
                }
            }
            if (!found)
                System.out.println("\n\nBook ID Not Found...");
            file.close();
            file1.close();
            File oldFile = new File("D://book.txt");
            oldFile.delete();
            File newFile = new File("D://book1.txt");
            newFile.renameTo(oldFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int choice;
        char x;
        Bookshop b = new Bookshop();

        while (true) {
            b.controlPanel();
            System.out.println("\n\nEnter your choice : ");
            Scanner scanner = new Scanner(System.in);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    do {
                        b.addBook();
                        System.out.println("\n\nWant to add another book? (y/n) : ");
                        x = scanner.next().charAt(0);
                    } while (x == 'y');
                    break;

                case 2:
                    b.showBook();
                    break;

                case 3:
                    b.checkBook();
                    break;
                case 4:
                    b.updateBook();
                    break;

                case 5:
                    b.deleteBook();
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("\n\nINVALID CHOICE\n");
            }
        }
    }
}
