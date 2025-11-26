import java.util.*;
import java.util.stream.*;

public class RatingsAnalyzer {
    public static void main(String[] args) {
        int[] prim = {5, 4, 3};
        List<Integer> boxed = new ArrayList<>(Arrays.asList(4, null, 5));

        List<Integer> all = new ArrayList<>();
        for (int x : prim) all.add(x);
        for (Integer r : boxed) if (Objects.nonNull(r)) all.add(r);

        double avg = all.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average rating: " + avg);
    }
}
