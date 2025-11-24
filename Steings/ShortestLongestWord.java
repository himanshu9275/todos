import java.util.Scanner;

public class ShortestLongestWord {

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

    // Method to split text into words using charAt(), no split()
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
                sb.append(text.charAt(i));
            }
            words[w] = sb.toString();

            start = end + 1;
        }

        return words;
    }

    // Method: take word array and return 2D array [word, lengthAsString]
    public static String[][] buildWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            int len = myLength(words[i]);
            table[i][1] = String.valueOf(len);
        }

        return table;
    }

    // Method: find shortest and longest word; return indices in int[2]
    // result[0] = index of shortest, result[1] = index of longest
    public static int[] findShortestAndLongest(String[][] wordLengthTable) {
        int minIndex = 0;
        int maxIndex = 0;

        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < wordLengthTable.length; i++) {
            int len = Integer.parseInt(wordLengthTable[i][1]);

            if (len < minLen) {
                minLen = len;
                minIndex = i;
            }
            if (len > maxLen) {
                maxLen = len;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String text = sc.nextLine();

        String[] words = mySplit(text);
        String[][] table = buildWordLengthTable(words);
        int[] result = findShortestAndLongest(table);

        int shortestIndex = result[0];
        int longestIndex = result[1];

        System.out.println("\nWord\t\tLength");
        System.out.println("-------------------------");
        for (int i = 0; i < table.length; i++) {
            String word = table[i][0];
            int len = Integer.parseInt(table[i][1]);
            System.out.println(word + "\t\t" + len);
        }

        System.out.println("\nShortest word: " + table[shortestIndex][0] +
                           " (length " + table[shortestIndex][1] + ")");
        System.out.println("Longest word : " + table[longestIndex][0] +
                           " (length " + table[longestIndex][1] + ")");
    }
}
