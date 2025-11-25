import java.util.*;

public class NumericSumDemo {

    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.0);

        System.out.println("Sum of Integers : " + sumNumbers(intList));
        System.out.println("Sum of Doubles  : " + sumNumbers(doubleList));
    }
}
