import java.util.*;

public class SensorLogger {
    public static void log(Double readingObj) {
        if (readingObj == null) System.out.println("No reading (null)");
        else System.out.println("Logged (wrapper): " + readingObj);
    }

    public static void logPrimitive(double readingPrimitive) {
        // primitive will auto-box if stored in a collection
        System.out.println("Logged (primitive): " + readingPrimitive);
    }

    public static void main(String[] args) {
        double p = 36.5;
        Double w = 37.2;

        log(w);
        logPrimitive(p);

        // show interchangeability with collections
        List<Double> cache = new ArrayList<>();
        cache.add(p);  // auto-boxing
        cache.add(w);
        System.out.println("Cache: " + cache);
    }
}
