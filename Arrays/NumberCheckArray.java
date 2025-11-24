import java.util.Scanner;

public class NumberCheckArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[5];

        // Get 5 numbers
        System.out.println("Enter 5 integers:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            nums[i] = sc.nextInt();
        }

        // Check each number
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            if (n > 0) {
                if (n % 2 == 0) {
                    System.out.println(n + " is positive and even.");
                } else {
                    System.out.println(n + " is positive and odd.");
                }
            } else if (n < 0) {
                System.out.println(n + " is negative.");
            } else { // n == 0
                System.out.println(n + " is zero.");
            }
        }

        // Compare first and last elements
        int first = nums[0];
        int last = nums[nums.length - 1];

        if (first == last) {
            System.out.println("The first and last elements are equal (" + first + ").");
        } else if (first > last) {
            System.out.println("The first element (" + first + ") is greater than the last element (" + last + ").");
        } else {
            System.out.println("The first element (" + first + ") is less than the last element (" + last + ").");
        }
    }
}
