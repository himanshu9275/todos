import java.util.Scanner;

public class ManualToUpperCase {

    // Method to convert lowercase letters to uppercase using ASCII logic
    public static String myToUpperCase(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If lowercase: 'a' (97) → 'A' (65)
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }

            sb.append(ch);
        }

        return sb.toString();
    }

    // Compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String manualUpper = myToUpperCase(text);     // user-defined
        String builtInUpper = text.toUpperCase();     // built-in

        System.out.println("\nManual Uppercase   : " + manualUpper);
        System.out.println("Built-in Uppercase : " + builtInUpper);

        boolean same = compareUsingCharAt(manualUpper, builtInUpper);

        System.out.println("\nAre both results equal? " + same);
    }
}
