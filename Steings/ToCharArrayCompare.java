import java.util.Scanner;

public class ToCharArrayCompare {
    
    // User-defined method to convert String to char[]
    public static char[] myToCharArray(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    // Compare two char arrays
    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        char[] userArray = myToCharArray(text);   // user-defined
        char[] builtInArray = text.toCharArray(); // built-in

        boolean same = compareCharArrays(userArray, builtInArray);

        System.out.println("User-defined char array: ");
        for (char c : userArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("Built-in toCharArray() result: ");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("Are both char arrays equal? " + same);
    }
}
