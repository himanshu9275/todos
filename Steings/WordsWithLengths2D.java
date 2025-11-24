import java.util.Scanner;

public class WordsWithLengths2D {

    // Method to find length without using length()
    public static int myLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }

    // Manual split using charAt()
    public static String[] mySplit(String text) {
        int n = myLength(text);

        int[] spaceIndexes = new int[n];
        int spaceCount = 0;

        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[spaceCount] = i;
                spaceCount++;
            }
        }

        int wordCount = spaceCount + 1;
        String[] words = new String[wordCount];

        int start = 0;
        for (int w = 0; w < wordCount; w++) {
            int end;
            if (w < spaceCount) {
                end = spaceIndexes[w];
            } else {
                end = n;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = start; i < end; i++) {
                text.charAt(i); // just for style, we already know it's safe
                sb.append(text.charAt(i));
            }
            words[w] = sb.toString();
            start = end + 1;
        }

        return words;
    }

    // Convert words[] into 2D array: [ word, lengthAsString ]
    public static String[][] toWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i]; // word
            int len = myLength(words[i]);
            table[i][1] = String.valueOf(len); // store length as String
        }

        return table;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String text = sc.nextLine();

        String[] words = mySplit(text);
        String[][] wordLengthTable = toWordLengthTable(words);

        // Display in tabular format
        System.out.println("\nWord\t\tLength");
        System.out.println("-------------------------");
        for (int i = 0; i < wordLengthTable.length; i++) {
            String word = wordLengthTable[i][0];
            // convert length String back to int before display, as per hint
            int len = Integer.parseInt(wordLengthTable[i][1]);

            System.out.println(word + "\t\t" + len);
        }
    }
}
