import java.util.Scanner;

public class CustomTrimDemo {

    // Find start and end indexes (end is exclusive) after trimming spaces
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        // end is inclusive now, make it exclusive for substring-style
        return new int[]{start, end + 1};
    }

    // Create substring using charAt()
    public static String mySubstring(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    // Compare 2 strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text with spaces: ");
        String text = sc.nextLine();

        int[] indexes = findTrimIndexes(text);
        String trimmedCustom = mySubstring(text, indexes[0], indexes[1]);

        String trimmedBuiltIn = text.trim();

        System.out.println("Custom trimmed text : [" + trimmedCustom + "]");
        System.out.println("Built-in trimmed    : [" + trimmedBuiltIn + "]");

        boolean same = compareUsingCharAt(trimmedCustom, trimmedBuiltIn);
        System.out.println("Are both results equal? " + same);
    }
}
