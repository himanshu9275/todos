import java.util.*;

public class SetToSortedList {

    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>(Arrays.asList(5,3,9,1));
        List<Integer> sorted = new ArrayList<>(nums);
        Collections.sort(sorted);

        System.out.println("Sorted List: " + sorted);
    }
}
