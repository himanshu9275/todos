import java.util.*;

public class CountryCapitalLookup {
    public static void main(String[] args) {

        Map<String, String> countries = new HashMap<>();

        // 1. Add country–capital pairs
        countries.put("India", "New Delhi");
        countries.put("USA", "Washington D.C.");
        countries.put("Japan", "Tokyo");
        countries.put("Germany", "Berlin");
        countries.put("France", "Paris");
        countries.put("Canada", "Ottawa");
        countries.put("Brazil", "Brasilia");
        countries.put("Australia", "Canberra");

        Scanner sc = new Scanner(System.in);

        // 2. User lookup
        System.out.print("Enter country name: ");
        String input = sc.nextLine();

        if (countries.containsKey(input)) {
            System.out.println("Capital of " + input + " is: " + countries.get(input));
        } else {
            System.out.println("Unknown country.");
        }

        // 3. Print all sorted alphabetically
        System.out.println("\n---- Country–Capital List (Alphabetical) ----");

        Map<String, String> sorted = new TreeMap<>(countries);

        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
