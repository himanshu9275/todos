import java.util.Scanner;

public class StringCompareCharAt {
    
    // Method to compare two strings using charAt()
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

        System.out.print("Enter first string: ");
        String str1 = sc.next();

        System.out.print("Enter second string: ");
        String str2 = sc.next();

        boolean resultCharAt = compareUsingCharAt(str1, str2);
        boolean resultEquals = str1.equals(str2);

        System.out.println("Result using charAt comparison : " + resultCharAt);
        System.out.println("Result using String equals()   : " + resultEquals);

        if (resultCharAt == resultEquals) {
            System.out.println("Both methods give the SAME result.");
        } else {
            System.out.println("Methods give DIFFERENT results (this should not normally happen).");
        }
    }
}
