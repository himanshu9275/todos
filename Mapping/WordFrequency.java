import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        String sentence = "Java is fun, and Java is powerful!";

        // Normalize: lowercase and remove punctuation
        sentence = sentence.toLowerCase().replaceAll("[^a-z ]", "");

        String[] words = sentence.split("\\s+");

        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            if (freq.containsKey(word)) {
                freq.put(word, freq.get(word) + 1);
            } else {
                freq.put(word, 1);
            }
        }

        // Display the results
        System.out.println("----- Word Frequency -----");
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
