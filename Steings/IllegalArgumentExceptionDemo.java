import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    // Method 1: generate the exception (no handling here)
    public static void generateIllegalArgumentException(String text) {
        System.out.println("Generating exception using substring(start > end)...");
        // This will cause a runtime exception (IndexOutOfBoundsException)
        String sub = text.substring(5, 2); // invalid: start > end
        System.out.println("Substring: " + sub);
    }

    // Method 2: demonstrate and handle with try-catch
    public static void handleIllegalArgumentException(String text) {
        System.out.println("\nHandling IllegalArgument-like case with try-catch...");
        try {
            String sub = text.substring(5, 2); // invalid again
            System.out.println("Substring: " + sub);
        } catch (IllegalArgumentException e) {
            // Will rarely be hit for substring, but shown for assignment’s sake
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            // This will actually catch IndexOutOfBoundsException / StringIndexOutOfBoundsException
            System.out.println("Caught generic RuntimeException: " + e.getClass().getSimpleName()
                               + " - " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        // First: call method that generates the exception
        try {
            generateIllegalArgumentException(text);
        } catch (RuntimeException e) {
            System.out.println("Exception occurred in generateIllegalArgumentException(): "
                               + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Then: call method that handles it with try-catch
        handleIllegalArgumentException(text);
    }
}
