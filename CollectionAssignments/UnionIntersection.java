import java.util.*;

public class UnionIntersection {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> b = new HashSet<>(Arrays.asList(3,4,5));

        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);

        Set<Integer> inter = new HashSet<>(a);
        inter.retainAll(b);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + inter);
    }
}
