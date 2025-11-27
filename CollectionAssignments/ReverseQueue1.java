import java.util.*;

public class ReverseQueue {

    public static <T> void reverse(Queue<T> q) {
        if (q.isEmpty()) return;

        T front = q.remove();
        reverse(q);
        q.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original Queue: " + q);
        reverse(q);
        System.out.println("Reversed Queue: " + q);
    }
}
