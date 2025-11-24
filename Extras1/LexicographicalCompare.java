import java.util.Scanner;

public class LexicographicalCompare {

    public static int myCompare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                return c1 - c2; // <0 if c1 < c2, >0 if c1 > c2
            }
        }

        // All equal till minLen – shorter one is "smaller"
        return len1 - len2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int cmp = myCompare(s1, s2);

        if (cmp < 0) {
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\"");
        } else if (cmp > 0) {
            System.out.println("\"" + s1 + "\" comes after \"" + s2 + "\"");
        } else {
            System.out.println("Both strings are equal.");
        }
    }
}
