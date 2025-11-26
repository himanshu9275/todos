import java.util.*;

/**
 * Library Management System Demo
 *
 * - Abstract class LibraryItem with abstract getLoanDuration() and concrete getItemDetails()
 * - Subclasses: Book, Magazine, DVD
 * - Reservable interface with reserveItem() and checkAvailability()
 * - Encapsulation of borrower personal data (private fields, masked display)
 * - Polymorphism demonstration: list of LibraryItem processed via base reference
 */

// Reservable interface
interface Reservable {
    /**
     * Attempt to reserve the item for borrower.
     * @param borrowerName borrower's visible name
     * @param contact borrower's contact (kept private)
     * @return true if reservation added (immediate or queued)
     */
    boolean reserveItem(String borrowerName, String contact);

    /**
     * Check if the item is currently available to borrow now (no active borrower).
     * @return true if available
     */
    boolean checkAvailability();
}

// Abstract LibraryItem — implements common reservation behavior
abstract class LibraryItem implements Reservable {
    private final String itemId;
    private final String title;
    private final String author;

    // Borrower details are private (encapsulation)
    private String currentBorrowerName = null;
    private String currentBorrowerContact = null; // kept private, never printed in full

    // Reservation queue — names + contact (contacts kept private)
    private final Queue<Reservation> reservationQueue = new LinkedList<>();

    // Internal class to hold reservation info (contact kept private)
    private static class Reservation {
        final String name;
        final String contact;
        Reservation(String name, String contact) {
            this.name = name;
            this.contact = contact;
        }
    }

    public LibraryItem(String itemId, String title, String author) {
        if (itemId == null || itemId.trim().isEmpty()) throw new IllegalArgumentException("Invalid itemId");
        if (title == null) title = "";
        if (author == null) author = "";
        this.itemId = itemId.trim();
        this.title = title.trim();
        this.author = author.trim();
    }

    // abstract method
    public abstract int getLoanDuration(); // in days

    // Concrete method to display details
    public void getItemDetails() {
        System.out.printf("ItemID: %s | Title: %s | Author: %s | Type: %s%n",
                itemId, title, author, this.getClass().getSimpleName());
        System.out.printf("  Loan Duration (days): %d%n", getLoanDuration());
        System.out.printf("  Available now: %s%n", checkAvailability() ? "Yes" : "No");
        if (currentBorrowerName != null) {
            System.out.printf("  Borrowed by: %s (contact: %s)%n",
                    currentBorrowerName, maskContact(currentBorrowerContact));
        }
        if (!reservationQueue.isEmpty()) {
            System.out.print("  Reservations in queue: ");
            // print only borrower names (not contact)
            List<String> names = new ArrayList<>();
            for (Reservation r : reservationQueue) names.add(r.name);
            System.out.println(String.join(", ", names));
        }
        System.out.println();
    }

    // Borrow the item (returns true if borrowed successfully)
    public boolean borrowItem(String borrowerName, String borrowerContact) {
        if (!checkAvailability()) {
            // If available but someone reserved it earlier and is not this borrower -> cannot borrow
            // If borrower is head of reservation queue, allow immediate borrowing
            Reservation head = reservationQueue.peek();
            if (head != null && head.name.equals(borrowerName)) {
                // pop reservation and assign
                reservationQueue.poll();
                assignBorrower(borrowerName, head.contact);
                return true;
            }
            return false;
        }
        // If available and no reservation, assign borrower
        assignBorrower(borrowerName, borrowerContact);
        return true;
    }

    // Return the item
    public void returnItem() {
        this.currentBorrowerName = null;
        this.currentBorrowerContact = null;
        // If there is someone in reservation queue, we could automatically notify/assign.
        // For demo: do not auto-assign; keep for manual process (or optionally auto-assign).
    }

    // Internal helper to set borrower (keeps contact private)
    private void assignBorrower(String borrowerName, String borrowerContact) {
        this.currentBorrowerName = borrowerName;
        this.currentBorrowerContact = borrowerContact;
        System.out.printf("%s has been borrowed by %s (contact masked) %n", title, borrowerName);
    }

    // Reservable interface implementation
    @Override
    public boolean reserveItem(String borrowerName, String contact) {
        // If borrower is already current borrower -> nothing to do
        if (borrowerName != null && borrowerName.equals(currentBorrowerName)) {
            System.out.println("You already have this item borrowed.");
            return false;
        }

        // If item is available and queue empty, create reservation and notify that they may borrow immediately
        if (checkAvailability() && reservationQueue.isEmpty()) {
            reservationQueue.offer(new Reservation(borrowerName, contact));
            System.out.printf("Reservation created for %s — item currently available. Please borrow within next 2 days.%n", borrowerName);
            return true;
        }

        // Otherwise add to queue
        reservationQueue.offer(new Reservation(borrowerName, contact));
        System.out.printf("Reservation added for %s. Position in queue: %d%n", borrowerName, reservationQueue.size());
        return true;
    }

    @Override
    public boolean checkAvailability() {
        return currentBorrowerName == null;
    }

    // Mask contact information for privacy when printing. Shows only last 4 chars if possible.
    private String maskContact(String contact) {
        if (contact == null) return "N/A";
        String trimmed = contact.trim();
        int len = trimmed.length();
        if (len <= 4) return "****" + trimmed;
        String last4 = trimmed.substring(len - 4);
        return "****" + last4;
    }

    // Controlled accessors (no direct access to contact)
    public String getCurrentBorrowerName() { return currentBorrowerName; }
    // No public getter for contact — intentionally omitted for privacy.

    // Utility to optionally notify next reservation and auto-assign (optional feature)
    public void notifyAndAssignNext() {
        if (currentBorrowerName != null) return; // still borrowed
        Reservation next = reservationQueue.poll();
        if (next != null) {
            assignBorrower(next.name, next.contact);
            System.out.printf("Assigned to next reservation: %s%n", next.name);
        }
    }
}

// Subclass: Book
class Book extends LibraryItem {
    private final String isbn;
    public Book(String itemId, String title, String author, String isbn) {
        super(itemId, title, author);
        this.isbn = isbn == null ? "" : isbn;
    }
    @Override
    public int getLoanDuration() { return 21; } // 21 days typical
    public String getIsbn() { return isbn; }
}

// Subclass: Magazine
class Magazine extends LibraryItem {
    private final int issueNumber;
    public Magazine(String itemId, String title, String author, int issueNumber) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
    }
    @Override
    public int getLoanDuration() { return 7; } // 1 week
    public int getIssueNumber() { return issueNumber; }
}

// Subclass: DVD
class DVD extends LibraryItem {
    private final int durationMinutes;
    public DVD(String itemId, String title, String author, int durationMinutes) {
        super(itemId, title, author);
        this.durationMinutes = durationMinutes;
    }
    @Override
    public int getLoanDuration() { return 3; } // 3 days
    public int getDurationMinutes() { return durationMinutes; }
}

// Demo runner
public class LibraryManagementDemo {
    public static void main(String[] args) {
        // Create several library items
        List<LibraryItem> catalog = new ArrayList<>();
        catalog.add(new Book("B001", "Effective Java", "Joshua Bloch", "978-0134685991"));
        catalog.add(new Magazine("M101", "National Geographic", "NatGeo", 202));
        catalog.add(new DVD("D501", "The Matrix", "The Wachowskis", 136));
        catalog.add(new Book("B002", "Clean Code", "Robert C. Martin", "978-0132350884"));

        // Polymorphism: treat all as LibraryItem
        System.out.println("=== Initial Catalog Details ===");
        for (LibraryItem item : catalog) {
            item.getItemDetails();
        }

        // Reserve & borrow actions
        System.out.println("=== Reservations & Borrowing ===");
        LibraryItem book1 = catalog.get(0); // Effective Java
        book1.reserveItem("Asha", "9876543210");   // reservation when available -> immediate "please borrow"
        boolean borrowed = book1.borrowItem("Asha", "9876543210"); // Asha borrows
        System.out.println("Borrowing success: " + borrowed);
        book1.getItemDetails();

        // Another user reserves while item is borrowed
        book1.reserveItem("Ravi", "9123456789");
        book1.reserveItem("Neha", "9988776655");
        book1.getItemDetails();

        // Return item, then notify and assign next in queue automatically
        System.out.println("Returning item...");
        book1.returnItem();
        book1.notifyAndAssignNext(); // assigns to Ravi
        book1.getItemDetails();

        // Check DVD borrowing (no reservations)
        LibraryItem dvd = catalog.stream().filter(i -> i instanceof DVD).findFirst().orElse(null);
        if (dvd != null) {
            boolean ok = dvd.borrowItem("Sonal", "7000111122");
            System.out.println("DVD borrowed by Sonal: " + ok);
            dvd.getItemDetails();
        }

        // Attempting to see contact directly is not possible — only masked contact shows in getItemDetails()
        System.out.println("\n=== Final Catalog Snapshot ===");
        for (LibraryItem item : catalog) item.getItemDetails();
    }
}
