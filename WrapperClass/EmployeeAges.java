import java.util.*;

public class EmployeeAges {
    public static void main(String[] args) {
        int[] ages = {25, 34, 19, 45, 29};
        List<Integer> list = new ArrayList<>();
        for (int a : ages) list.add(a); // boxing
        System.out.println("Youngest: " + Collections.min(list));
        System.out.println("Oldest: " + Collections.max(list));
    }
}
