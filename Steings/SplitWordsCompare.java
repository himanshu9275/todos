import java.util.Scanner;

public class SplitWordsCompare {

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

        // First pass: count spaces (assuming single spaces between words)
        int[] spaceIndexes = new int[n]; // max possible
        int spaceCount = 0;

        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[spaceCount] = i;
                spaceCount++;
            }
        }

        int wordCount = spaceCount + 1;
        String[] words = new String[wordCount];

        // Build words using indexes
        int start = 0;
        for (int w = 0; w < wordCount; w++) {
            int end;
            if (w < spaceCount) {
                end = spaceIndexes[w];
            } else {
                end = n; // last word till end
            }

            StringBuilder sb = new StringBuilder();
            for (int i = start; i < end; i++) {
                sb.append(text.charAt(i));
            }
            words[w] = sb.toString();
            start = end + 1; // next start after space
        }

        return words;
    }

    // Compare two String arrays
    public static boolean compareStringArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String text = sc.nextLine();

        String[] manualWords = mySplit(text);      // user-defined
        String[] builtInWords = text.split(" ");   // built-in

        // Display both sets
        System.out.println("\nWords using user-defined split:");
        for (String w : manualWords) {
            System.out.println(w);
        }

        System.out.println("\nWords using built-in split():");
        for (String w : builtInWords) {
            System.out.println(w);
        }

        boolean same = compareStringArrays(manualWords, builtInWords);
        System.out.println("\nAre both word arrays equal? " + same);
    }
}
