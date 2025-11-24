import java.util.Scanner;

public class LeapYearCheck {

    // Method to check leap year based on given rules
    public static boolean isLeapYear(int year) {
        if (year < 1582) {
            return false; // outside Gregorian calendar
        }

        // Divisible by 400 OR (divisible by 4 AND not by 100)
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (year < 1582) {
            System.out.println("The LeapYear rule applies only for year >= 1582.");
        }

        if (isLeapYear(year)) {
            System.out.println("The Year " + year + " is a Leap Year");
        } else {
            System.out.println("The Year " + year + " is NOT a Leap Year");
        }
    }
}
