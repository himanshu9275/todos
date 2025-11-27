import java.util.*;

public class RotateList {

    public static <T> List<T> rotate(List<T> list, int k) {
        int n = list.size();
        if (n == 0) return list;

        k = k % n;
        List<T> rotated = new ArrayList<>();

        for (int i = k; i < n; i++) rotated.add(list.get(i));
        for (int i = 0; i < k; i++) rotated.add(list.get(i));

        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10,20,30,40,50);
        System.out.println("Original: " + nums);
        System.out.println("Rotated by 2: " + rotate(nums, 2));
    }
}
