import java.util.*;

class BookNotAvailableException extends Exception { BookNotAvailableException(String m){super(m);} }
class InvalidReturnException extends Exception { InvalidReturnException(String m){super(m);} }
class UserLimitExceededException extends Exception { UserLimitExceededException(String m){super(m);} }

public class Library {
    Map<String, Boolean> available = new HashMap<>();
    Map<String, List<String>> userBorrowed = new HashMap<>();

    public Library() {
        available.put("BookA", true);
        available.put("BookB", true);
    }

    void borrow(String user, String book) throws BookNotAvailableException, UserLimitExceededException {
        List<String> borrowed = userBorrowed.getOrDefault(user, new ArrayList<>());
        if (borrowed.size() >= 5) throw new UserLimitExceededException("User limit exceeded");
        if (!available.getOrDefault(book, false)) throw new BookNotAvailableException(book + " not available");
        borrowed.add(book);
        userBorrowed.put(user, borrowed);
        available.put(book, false);
    }

    void returnBook(String user, String book) throws InvalidReturnException {
        List<String> borrowed = userBorrowed.getOrDefault(user, new ArrayList<>());
        if (!borrowed.remove(book)) throw new InvalidReturnException("Return invalid: " + book);
        available.put(book, true);
    }

    public static void main(String[] args) {
        Library lib = new Library();
        try {
            lib.borrow("Alice", "BookA");
            lib.borrow("Bob", "BookA"); // will throw
        } catch (Exception e) {
            System.out.println("Library error: " + e.getMessage());
        }
    }
}
