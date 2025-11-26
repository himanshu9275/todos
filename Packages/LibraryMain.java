import library.books.Book;
import library.members.Member;
import library.transactions.Transaction;

public class LibraryMain {
    public static void main(String[] args) {
        Book book = new Book("ISBN001","Java Fundamentals");
        Member member = new Member("M001","Rita");

        System.out.println("Issuing book...");
        boolean ok = Transaction.issueBook(book, member);
        System.out.println("Issued? " + ok);

        System.out.println("Returning book...");
        boolean ret = Transaction.returnBook(book, member);
        System.out.println("Returned? " + ret);
    }
}
