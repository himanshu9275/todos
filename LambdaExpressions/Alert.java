import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Alert {
    String type;   // e.g., "critical", "info", "reminder"
    String message;
    int priority;  // higher = more important

    Alert(String t, String m, int p) { type=t; message=m; priority=p; }

    @Override public String toString() { return "[" + type + ", p=" + priority + "] " + message; }

    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("critical", "Cardiac monitor alarm", 10),
            new Alert("info", "Daily summary ready", 2),
            new Alert("reminder", "Medication due", 6),
            new Alert("critical", "Respiratory alert", 9)
        );

        // Example preference: show only critical alerts
        Predicate<Alert> showCritical = a -> "critical".equalsIgnoreCase(a.type);

        // Or preference: show alerts priority >= 6
        Predicate<Alert> highPriority = a -> a.priority >= 6;

        System.out.println("Critical alerts:");
        alerts.stream().filter(showCritical).forEach(System.out::println);

        System.out.println("\nHigh-priority alerts:");
        alerts.stream().filter(highPriority).forEach(System.out::println);

        // Combine predicates dynamically (e.g., user wants critical OR high priority)
        Predicate<Alert> combined = showCritical.or(highPriority);
        System.out.println("\nCombined filter (critical OR high priority):");
        alerts.stream().filter(combined).forEach(System.out::println);
    }
}
