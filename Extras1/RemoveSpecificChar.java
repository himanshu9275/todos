import java.util.Scanner;

public class RemoveSpecificChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.print("Enter character to remove: ");
        char remove = sc.next().charAt(0);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != remove) {
                result.append(ch);
            }
        }

        System.out.println("Modified String: " + result);
    }
}
