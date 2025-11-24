import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {

    public static String sortChars(String s) {
        char[] arr = s.toLowerCase().replaceAll("\\s+", "").toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        String sorted1 = sortChars(s1);
        String sorted2 = sortChars(s2);

        if (sorted1.equals(sorted2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are NOT anagrams.");
        }
    }
}
