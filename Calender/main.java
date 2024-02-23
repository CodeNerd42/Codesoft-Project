import java.util.Scanner;

public class CalendarGenerator {
    public static int firstWeekday(int year) {
        int day;
        day = (((year - 1) * 365) + ((year - 1) / 4) - ((year - 1) / 100) + (year / 400) + 1) % 7;
        return day;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your desired year: ");
        int year = scanner.nextInt();

        String[] months = {"January~~",
                "February~",
                "March~~~~",
                "April~~~~",
                "May~~~~~~",
                "June~~~~~",
                "July~~~~~",
                "August~~~",
                "September",
                "October~~",
                "November~",
                "December~"};

        int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            monthDay[1] = 29;

        int firstDay = firstWeekday(year);

        for (int month = 0; month < 12; month++) {
            int daysInMonth = monthDay[month];
            System.out.printf("\n\n~~~~~~~~~~~~~~~%s~~~~~~~~~~~~~~~~~~~\n", months[month]);
            System.out.println("\n  Sun  Mon  Tue  Wed  Thurs  Fri  Sat");

            for (int weekDay = 0; weekDay < firstDay; weekDay++)
                System.out.print("     ");

            for (int day = 1; day <= daysInMonth; day++) {
                System.out.printf("%5d", day);
                if (++firstDay > 6) {
                    System.out.println();
                    firstDay = 0;
                }
            }
        }
        System.out.println("\n\n\n\t\t\t@Sushant_Gaurav\n\n\n\n\n\n");
    }
}
