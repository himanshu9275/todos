import java.util.*;

public class CourseRegistrationSystem {

    public static void main(String[] args) {

        Map<String, Integer> courses = new HashMap<>();

        // 1. Add courses with initial counts
        courses.put("CS101", 45);
        courses.put("CS102", 4);
        courses.put("MA201", 52);
        courses.put("PH110", 12);
        courses.put("EC210", 3);

        System.out.println("Initial course registrations: " + courses);

        // 2. Add or drop students
        System.out.println("\nUpdating registrations...");

        // Simulate adding students
        addStudents(courses, "CS101", 10);
        addStudents(courses, "CS102", 3);

        // Simulate dropping students
        dropStudents(courses, "EC210", 2);
        dropStudents(courses, "PH110", 20); // should not go negative

        // 3. Print near full and under-subscribed
        System.out.println("\n--- Courses Near Full (≥50) ---");
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            if (entry.getValue() >= 50) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        System.out.println("\n--- Under-Subscribed Courses (<5) ---");
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        System.out.println("\nFinal Course Registrations: " + courses);
    }

    // Increase count
    public static void addStudents(Map<String, Integer> map, String course, int count) {
        int newCount = map.getOrDefault(course, 0) + count;
        map.put(course, newCount);
        System.out.println(count + " students added to " + course + ". New count: " + newCount);
    }

    // Decrease count (never negative)
    public static void dropStudents(Map<String, Integer> map, String course, int count) {
        int current = map.getOrDefault(course, 0);
        int newCount = Math.max(0, current - count); // prevent negative
        map.put(course, newCount);
        System.out.println(count + " students dropped from " + course + ". New count: " + newCount);
    }
}
