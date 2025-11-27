import java.util.*;

public class ReverseList {

    // Reverse ArrayList
    public static <T> void reverseArrayList(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            T temp = list.get(i);
            list.set(i, list.get(n - 1 - i));
            list.set(n - 1 - i, temp);
        }
    }

    // Reverse LinkedList
    public static <T> LinkedList<T> reverseLinkedList(LinkedList<T> list) {
        LinkedList<T> reversed = new LinkedList<>();
        for (T item : list) {
            reversed.addFirst(item);
        }
        return reversed;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("Original ArrayList: " + arr);
        reverseArrayList(arr);
        System.out.println("Reversed ArrayList: " + arr);

        LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("Original LinkedList: " + ll);
        System.out.println("Reversed LinkedList: " + reverseLinkedList(ll));
    }
}
