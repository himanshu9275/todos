import java.util.*;

public class SymmetricDifference {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> b = new HashSet<>(Arrays.asList(3,4,5));

        Set<Integer> diff = new HashSet<>(a);
        diff.addAll(b);

        Set<Integer> inter = new HashSet<>(a);
        inter.retainAll(b);

        diff.removeAll(inter);

        System.out.println("Symmetric Difference: " + diff);
    }
}
