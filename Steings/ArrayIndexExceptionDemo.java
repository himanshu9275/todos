import java.util.Scanner;

public class ArrayIndexExceptionDemo {

    // Method 1: generate the exception (no try-catch here)
    public static void generateArrayIndexException(String[] names) {
        System.out.println("Generating ArrayIndexOutOfBoundsException...");
        // Access an index larger than or equal to length
        String value = names[names.length];   // last valid index is length - 1
        System.out.println("Name at invalid index: " + value);
    }

    // Method 2: demonstrate and handle the exception with try-catch
    public static void handleArrayIndexException(String[] names) {
        System.out.println("\nHandling ArrayIndexOutOfBoundsException with try-catch...");

        try {
            String value = names[names.length]; // again invalid index
            System.out.println("Name at invalid index: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " 
                               + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many names you want to enter? ");
        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        String[] names = new String[n];

        System.out.println("Enter " + n + " names:");
        for (int i = 0; i < n; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        // First: call method that generates the exception
        try {
            generateArrayIndexException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception occurred in generateArrayIndexException(): " + e.getMessage());
        }

        // Then: call method that handles it properly
        handleArrayIndexException(names);
    }
}
