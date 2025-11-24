import java.util.Scanner;

public class StringLengthWithoutLength {

    // Method to find length without using length()
    public static int myLength(String text) {
        int count = 0;

        while (true) {
            try {
                text.charAt(count); // will throw when count == actual length
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break; // stop when we go beyond last index
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String text = sc.next(); // as per hint

        int customLen = myLength(text);
        int builtInLen = text.length();

        System.out.println("Length using user-defined method : " + customLen);
        System.out.println("Length using built-in length()   : " + builtInLen);
    }
}
