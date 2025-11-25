import java.util.*;

public class StudentGradeTracker {

    public static void main(String[] args) {

        // Map: studentName → grade
        Map<String, Double> grades = new HashMap<>();

        // 1. Add several students
        grades.put("Rohan", 85.5);
        grades.put("Anjali", 92.0);
        grades.put("Meena", 76.0);
        grades.put("Vikas", 88.0);

        System.out.println("Initial Grades: " + grades);

        // 2. Update a student's grade
        System.out.println("\nUpdating Meena's grade...");
        grades.put("Meena", 82.0);

        // 3. Remove a student
        System.out.println("Removing Vikas (dropped out)...");
        grades.remove("Vikas");

        // 4. Print sorted by student name
        System.out.println("\n--- Sorted Student Grades ---");

        // Use TreeMap to sort by key automatically
        Map<String, Double> sortedMap = new TreeMap<>(grades);

        for (Map.Entry<String, Double> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
