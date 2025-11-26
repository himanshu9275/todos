// Parent Class
class Book {
    public String ISBN;           // public
    protected String title;       // protected
    private String author;        // private

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public setter
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public getter
    public String getAuthor() {
        return author;
    }

    public void showBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass demonstrating access modifiers
class EBook extends Book {
    private double fileSize;

    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    public void showEBookDetails() {
        System.out.println("E-Book ISBN (public): " + ISBN);      // Allowed
        System.out.println("E-Book Title (protected): " + title);  // Allowed
        System.out.println("File Size: " + fileSize + " MB");
    }
}

// Test class
public class LibraryDemo {
    public static void main(String[] args) {
        EBook ebook = new EBook("978-1234567890", "Java Programming", "James Gosling", 2.5);

        ebook.showBookDetails();
        ebook.showEBookDetails();

        ebook.setAuthor("Updated Author");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}
