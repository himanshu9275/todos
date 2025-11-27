class Book {
   // Static variable shared across all instances
   private static String libraryName;
   // Instance variables
   private String title;
   private String author;
   private final String isbn; // Final variable to ensure immutability
   // Constructor to initialize instance variables
   public Book(String title, String author, String isbn) {
       this.title = title;
       this.author = author;
       this.isbn = isbn;
   }
   // Static method to set the library name
   public static void setLibraryName(String name) {
       libraryName = name;
   }
   // Static method to display the library name
   public static void displayLibraryName() {
       System.out.println("Library Name: " + libraryName);
   }
