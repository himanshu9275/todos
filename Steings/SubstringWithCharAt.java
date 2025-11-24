import java.util.Scanner;

public class SubstringWithCharAt {
    
    // Create substring using charAt() from start (inclusive) to end (exclusive)
    public static String mySubstring(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    // Compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index (exclusive): ");
        int end = sc.nextInt();

        // Basic bounds check
        if (start < 0 || end > text.length() || start > end) {
            System.out.println("Invalid start or end index.");
            return;
        }

        String sub1 = mySubstring(text, start, end);          // user-defined
        String sub2 = text.substring(start, end);             // built-in

        System.out.println("Substring using charAt()   : " + sub1);
        System.out.println("Substring using substring(): " + sub2);

        boolean same = compareUsingCharAt(sub1, sub2);
        System.out.println("Are both substrings equal (charAt compare)? " + same);
    }
}
