import java.util.Scanner;

public class NumberFormatExceptionDemo {

    // Method 1: generate the exception (no internal handling)
    public static void generateNumberFormatException(String text) {
        System.out.println("Generating NumberFormatException...");
        // If text is not a valid integer, this line will throw NumberFormatException
        int value = Integer.parseInt(text);
        System.out.println("Parsed number: " + value);
    }

    // Method 2: demonstrate and handle NumberFormatException with try-catch
    public static void handleNumberFormatException(String text) {
        System.out.println("\nHandling NumberFormatException with try-catch...");
        try {
            int value = Integer.parseInt(text);
            System.out.println("Parsed number: " + value);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.getClass().getSimpleName()
                               + " - " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter some text (ideally NOT a number to trigger exception): ");
        String text = sc.nextLine();

        // First: call method that generates the exception
        try {
            generateNumberFormatException(text);
        } catch (NumberFormatException e) {
            System.out.println("Exception occurred in generateNumberFormatException(): " + e.getMessage());
        }

        // Then: call method that handles it with try-catch
        handleNumberFormatException(text);
    }
}
