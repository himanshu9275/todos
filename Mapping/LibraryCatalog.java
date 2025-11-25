import java.util.*;

public class LibraryCatalog {

    // Search by title (extended feature)
    public static void searchByTitle(Map<String, String> books, String title) {
        boolean found = false;

        for (Map.Entry<String, String> entry : books.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(title)) {
                System.out.println("Book found! ISBN: " + entry.getKey());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book with title \"" + title + "\" not found.");
        }
    }

    public static void main(String[] args) {

        // Map: ISBN → Title
        Map<String, String> catalog = new HashMap<>();

        // 1. Add several books
        catalog.put("978-1234567890", "Java Programming");
        catalog.put("978-0987654321", "Data Structures");
        catalog.put("978-1111111111", "Machine Learning Basics");

        // 2. Search by ISBN
        String isbnSearch = "978-0987654321";
        if (catalog.containsKey(isbnSearch)) {
            System.out.println("Book found: " + catalog.get(isbnSearch));
        } else {
            System.out.println("Book not found.");
        }

        // 3. Remove a book
        System.out.println("\nRemoving book with ISBN 978-1111111111...");
        catalog.remove("978-1111111111");

        // 4. Print all books sorted by ISBN
        System.out.println("\n----- Library Catalog (Sorted by ISBN) -----");
        Map<String, String> sorted = new TreeMap<>(catalog);

        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Extended Feature: Search by Title
        System.out.println("\nSearching by Title: \"Java Programming\"");
        searchByTitle(catalog, "Java Programming");
    }
}
