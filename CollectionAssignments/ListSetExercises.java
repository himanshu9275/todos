import java.util.*;

/**
 * ListSetExercises
 * Solutions to List and Set interface tasks (compact demo).
 */
public class ListSetExercises {

    // ---------------------
    // List Interface Tasks
    // ---------------------

    // 1. Reverse an ArrayList in-place (without Collections.reverse)
    public static <T> void reverseArrayList(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            T tmp = list.get(i);
            list.set(i, list.get(n - 1 - i));
            list.set(n - 1 - i, tmp);
        }
    }

    // 1b. Reverse a LinkedList (build a new LinkedList using addFirst)
    public static <T> LinkedList<T> reverseLinkedList(LinkedList<T> list) {
        LinkedList<T> rev = new LinkedList<>();
        for (T item : list) {
            rev.addFirst(item); // efficient for LinkedList
        }
        return rev;
    }

    // 2. Frequency map for a list of strings
    public static Map<String, Integer> frequency(List<String> list) {
        Map<String, Integer> freq = new LinkedHashMap<>(); // keep insertion order (optional)
        for (String s : list) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        return freq;
    }

    // 3. Rotate elements in a list by k positions (left rotate by k)
    public static <T> List<T> rotateLeft(List<T> list, int k) {
        int n = list.size();
        if (n == 0) return new ArrayList<>(list);
        k = ((k % n) + n) % n; // normalize
        List<T> res = new ArrayList<>(n);
        for (int i = k; i < n; i++) res.add(list.get(i));
        for (int i = 0; i < k; i++) res.add(list.get(i));
        return res;
    }

    // 4. Remove duplicates while preserving order
    public static <T> List<T> removeDuplicatesPreserveOrder(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (seen.add(item)) result.add(item);
        }
        return result;
    }

    // 5. Find Nth element from end in a LinkedList without calculating size
    // N is 1-based: N=1 -> last element
    public static <T> T nthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be >= 1");
        Iterator<T> p1 = list.iterator();
        Iterator<T> p2 = list.iterator();
        // advance p1 by n steps
        for (int i = 0; i < n; i++) {
            if (!p1.hasNext()) throw new NoSuchElementException("List smaller than n");
            p1.next();
        }
        // move both until p1 reaches end
        while (p1.hasNext()) {
            p1.next();
            p2.next();
        }
        // p2 is at the Nth from end
        return p2.next();
    }

    // ---------------------
    // Set Interface Tasks
    // ---------------------

    // 1. Check if two sets are equal (regardless of order)
    public static <T> boolean setsEqual(Set<T> a, Set<T> b) {
        return a.equals(b);
    }

    // 2. Union and intersection
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> u = new HashSet<>(a);
        u.addAll(b);
        return u;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> inter = new HashSet<>(a);
        inter.retainAll(b);
        return inter;
    }

    // 3. Symmetric difference (elements in either but not both)
    public static <T> Set<T> symmetricDifference(Set<T> a, Set<T> b) {
        Set<T> union = union(a, b);
        Set<T> inter = intersection(a, b);
        union.removeAll(inter);
        return union;
    }

    // 4. Convert a Set to a sorted list (ascending)
    public static List<Integer> setToSortedList(Set<Integer> set) {
        List<Integer> l = new ArrayList<>(set);
        Collections.sort(l);
        return l;
    }

    // 5. Check subset: is a subset of b?
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }

    // ---------------------
    // Demo main
    // ---------------------
    public static void main(String[] args) {
        System.out.println("=== List Interface Tasks ===");

        // 1. Reverse list
        ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: " + aList);
        reverseArrayList(aList);
        System.out.println("Reversed ArrayList: " + aList);

        LinkedList<Integer> lList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original LinkedList: " + lList);
        LinkedList<Integer> revL = reverseLinkedList(lList);
        System.out.println("Reversed LinkedList: " + revL);

        // 2. Frequency
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println("\nInput: " + fruits);
        System.out.println("Frequencies: " + frequency(fruits));

        // 3. Rotate elements by 2
        List<Integer> rotInput = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println("\nRotate Input: " + rotInput + " by 2");
        List<Integer> rotated = rotateLeft(rotInput, 2);
        System.out.println("Rotated: " + rotated);

        // 4. Remove duplicates preserving order
        List<Integer> dupInput = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("\nRemove duplicates from: " + dupInput);
        System.out.println("After removal: " + removeDuplicatesPreserveOrder(dupInput));

        // 5. Nth from end
        LinkedList<String> letters = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println("\nLinkedList: " + letters);
        int N = 2;
        System.out.println("Nth from end N=" + N + " -> " + nthFromEnd(letters, N));

        // ---------------------
        System.out.println("\n=== Set Interface Tasks ===");

        // 1. Check equality
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 2, 1));
        System.out.println("Set1: " + s1 + ", Set2: " + s2 + " -> equal? " + setsEqual(s1, s2));

        // 2. Union & Intersection
        Set<Integer> sa = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> sb = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println("\nUnion of " + sa + " and " + sb + " = " + union(sa, sb));
        System.out.println("Intersection = " + intersection(sa, sb));

        // 3. Symmetric difference
        System.out.println("\nSymmetric difference = " + symmetricDifference(sa, sb));

        // 4. Convert set to sorted list
        Set<Integer> unsorted = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("\nUnsorted set: " + unsorted);
        System.out.println("Sorted list: " + setToSortedList(unsorted));

        // 5. Subset check
        Set<Integer> small = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> big = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("\nIs " + small + " subset of " + big + "? " + isSubset(small, big));
    }
}
