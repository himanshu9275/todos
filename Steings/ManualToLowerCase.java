import java.util.Scanner;

public class ManualToLowerCase {

    // Method to convert uppercase letters to lowercase using ASCII logic
    public static String myToLowerCase(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If uppercase: 'A' (65) → 'a' (97)
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
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

        String manualLower = myToLowerCase(text);      // user-defined
        String builtInLower = text.toLowerCase();      // built-in

        System.out.println("\nManual Lowercase   : " + manualLower);
        System.out.println("Built-in Lowercase : " + builtInLower);

        boolean same = compareUsingCharAt(manualLower, builtInLower);

        System.out.println("\nAre both results equal? " + same);
    }
}
