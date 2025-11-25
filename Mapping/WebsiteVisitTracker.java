import java.util.*;

public class WebsiteVisitTracker {

    public static void main(String[] args) {

        Map<String, Integer> visits = new HashMap<>();

        // Simulated visited pages
        String[] pages = {
            "Home", "About", "Home", "Contact", "Home", "Products",
            "Products", "Home", "Contact", "About", "Blog", "Home"
        };

        // Count visits
        for (String page : pages) {
            visits.put(page, visits.getOrDefault(page, 0) + 1);
        }

        // Sort pages by descending visit count
        List<Map.Entry<String, Integer>> list = new ArrayList<>(visits.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue()); // descending order

        System.out.println("----- Page Visit Counts (Descending) -----");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Find most visited page
        Map.Entry<String, Integer> mostVisited = list.get(0);

        System.out.println("\nMost Visited Page: " +
                mostVisited.getKey() + " (" + mostVisited.getValue() + " visits)");
    }
}
