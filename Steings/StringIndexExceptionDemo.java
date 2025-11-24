import java.util.Scanner;

public class StringIndexExceptionDemo {

    // Method 1: generate the exception (no try-catch here)
    public static void generateStringIndexException(String text) {
        System.out.println("Generating StringIndexOutOfBoundsException...");
        // Access index equal to length (out of range, since last valid index is length-1)
        char ch = text.charAt(text.length());
        System.out.println("Character at out-of-range index: " + ch);
    }

    // Method 2: demonstrate and handle the exception with try-catch
    public static void handleStringIndexException(String text) {
        System.out.println("\nHandling StringIndexOutOfBoundsException with try-catch...");
        try {
            char ch = text.charAt(text.length()); // again out of range
            System.out.println("Character at out-of-range index: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        // First: call method that generates the exception
        try {
            generateStringIndexException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception occurred in generateStringIndexException(): " + e.getMessage());
        }

        // Then: call method that handles it with try-catch
        handleStringIndexException(text);
    }
}
