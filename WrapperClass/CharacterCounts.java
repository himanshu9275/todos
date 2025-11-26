import java.util.Scanner;

public class CharacterCounts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();

        int letters = 0, digits = 0, special = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) letters++;
            else if (Character.isDigit(ch)) digits++;
            else if (Character.isWhitespace(ch)) { /* ignore whitespace */ }
            else special++;
        }

        System.out.println("Letters: " + letters);
        System.out.println("Digits: " + digits);
        System.out.println("Special characters: " + special);
    }
}
