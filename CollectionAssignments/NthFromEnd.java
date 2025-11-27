import java.util.*;

public class NthFromEnd {

    public static <T> T nthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> p1 = list.iterator();
        Iterator<T> p2 = list.iterator();

        for (int i = 0; i < n; i++) {
            if (!p1.hasNext()) throw new RuntimeException("List too small");
            p1.next();
        }

        while (p1.hasNext()) {
            p1.next();
            p2.next();
        }

        return p2.next();
    }

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>(Arrays.asList("A","B","C","D","E"));
        System.out.println("List: " + ll);
        System.out.println("2nd from end: " + nthFromEnd(ll, 2));
    }
}
