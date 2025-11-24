import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] words = sentence.split("\\s+");

        String longest = "";
        for (String w : words) {
            if (w.length() > longest.length()) {
                longest = w;
            }
        }

        System.out.println("Longest word: " + longest);
    }
}
