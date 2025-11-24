import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int[] freq = new int[256];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        char mostFreq = 0;
        int maxCount = 0;

        for (int i = 0; i < 256; i++) {
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                mostFreq = (char) i;
            }
        }

        System.out.println("Most Frequent Character: '" + mostFreq + "'");
        System.out.println("Count: " + maxCount);
    }
}
