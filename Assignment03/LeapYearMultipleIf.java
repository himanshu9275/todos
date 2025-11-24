import java.util.Scanner;

public class LeapYearMultipleIf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if (year < 1582) {
            System.out.println("The rule for Leap Year does not apply before 1582.");
        }
        else if (year % 400 == 0) {
            System.out.println("The Year " + year + " is a Leap Year");
        }
        else if (year % 100 == 0) {
            System.out.println("The Year " + year + " is NOT a Leap Year");
        }
        else if (year % 4 == 0) {
            System.out.println("The Year " + year + " is a Leap Year");
        }
        else {
            System.out.println("The Year " + year + " is NOT a Leap Year");
        }
    }
}
