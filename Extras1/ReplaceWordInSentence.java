import java.util.Scanner;

public class ReplaceWordInSentence {

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                sb.append(newWord);
            } else {
                sb.append(words[i]);
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        System.out.print("Word to replace: ");
        String oldWord = sc.nextLine();

        System.out.print("New word: ");
        String newWord = sc.nextLine();

        String modified = replaceWord(sentence, oldWord, newWord);

        System.out.println("Modified Sentence: " + modified);
    }
}
