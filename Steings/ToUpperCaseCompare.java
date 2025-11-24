import java.util.Scanner;

public class ToUpperCaseCompare {

    // Method: convert string to uppercase using charAt and ASCII logic
    public static String myToUpperCase(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);  // convert to uppercase
            }

            sb.append(ch);
        }
        return sb.toString();
    }

    // Compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

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

        String upperManual = myToUpperCase(text);
        String upperBuiltIn = text.toUpperCase();

        System.out.println("Manual toUpperCase : " + upperManual);
        System.out.println("Built-in toUpperCase: " + upperBuiltIn);

        boolean same = compareUsingCharAt(upperManual, upperBuiltIn);
        System.out.println("Are both uppercase strings equal? " + same);
    }
}
