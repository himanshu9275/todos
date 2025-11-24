import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32)); // to uppercase
            } else if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32)); // to lowercase
            } else {
                result.append(ch); // non-letter stay same
            }
        }

        System.out.println("Toggled: " + result);
    }
}
