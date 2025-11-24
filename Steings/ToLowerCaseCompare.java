import java.util.Scanner;

public class ToLowerCaseCompare {

    // Method: convert string to lowercase using charAt and ASCII logic
    public static String myToLowerCase(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);  // convert to lowercase
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

        String lowerManual = myToLowerCase(text);
        String lowerBuiltIn = text.toLowerCase();

        System.out.println("Manual toLowerCase : " + lowerManual);
        System.out.println("Built-in toLowerCase: " + lowerBuiltIn);

        boolean same = compareUsingCharAt(lowerManual, lowerBuiltIn);
        System.out.println("Are both lowercase strings equal? " + same);
    }
}
