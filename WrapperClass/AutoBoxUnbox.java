import java.util.*;

public class AutoBoxUnbox {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(10); nums.add(11); nums.add(12); nums.add(13); nums.add(9); // auto-boxing
        int sum = 0;
        for (Integer n : nums) sum += n; // auto-unboxing
        System.out.println("Sum of numbers = " + sum); // expected 55
    }
}
