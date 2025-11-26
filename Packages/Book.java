package library.books;

public class Book {
    private String isbn, title;
    private boolean issued;

    public Book(String isbn, String title) {
        this.isbn = isbn; this.title = title; this.issued = false;
    }
    public String getIsbn(){return isbn;}
    public String getTitle(){return title;}
    public boolean isIssued(){return issued;}
    public void setIssued(boolean v){issued = v;}
}
