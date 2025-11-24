import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter main string: ");
        String text = sc.nextLine();

        System.out.print("Enter substring to find: ");
        String sub = sc.nextLine();

        int count = 0;
        int index = 0;

        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index = index + sub.length(); // move forward
        }

        System.out.println("Occurrences: " + count);
    }
}
