import java.util.*;
import java.util.function.Predicate;

public class TempAlert {
    public static void main(String[] args) {
        List<Double> readings = Arrays.asList(36.5, 39.2, 40.1, 37.8);
        double threshold = 38.0;
        Predicate<Double> alertIfHigh = t -> t >= threshold;

        readings.stream().filter(alertIfHigh).forEach(t -> System.out.println("ALERT: high temp " + t));
    }
}
