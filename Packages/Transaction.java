package library.transactions;

import library.books.Book;
import library.members.Member;
import java.util.*;

public class Transaction {
    private static Map<String, String> issuedMap = new HashMap<>(); // isbn -> memberId

    public static boolean issueBook(Book b, Member m){
        if(b.isIssued()) return false;
        b.setIssued(true);
        issuedMap.put(b.getIsbn(), m.getMemberId());
        return true;
    }

    public static boolean returnBook(Book b, Member m){
        String mid = issuedMap.get(b.getIsbn());
        if(mid == null || !mid.equals(m.getMemberId())) return false;
        b.setIssued(false);
        issuedMap.remove(b.getIsbn());
        return true;
    }
}
