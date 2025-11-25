import java.util.*;

public class AttendanceTracker {

    public static void main(String[] args) {

        // 5 students
        List<String> students = Arrays.asList("Arjun", "Bhavna", "Chetan", "Divya", "Eshan");

        // Map: student name -> days present
        Map<String, Integer> attendance = new HashMap<>();

        // 1. Initialize all with 0 attendance
        for (String student : students) {
            attendance.put(student, 0);
        }

        // 2. Simulate attendance for 15 days
        Random random = new Random();

        System.out.println("----- Daily Attendance -----");

        for (int day = 1; day <= 15; day++) {

            System.out.print("Day " + day + ": Present students: ");

            // Simulate present students
            for (String student : students) {
                boolean isPresent = random.nextBoolean(); // true = present

                if (isPresent) {
                    attendance.put(student, attendance.get(student) + 1);
                    System.out.print(student + " ");
                }
            }
            System.out.println();
        }

        // 3. Print under-attending students (less than 10 days)
        System.out.println("\n----- Students Present Less Than 10 Days -----");

        for (String student : students) {
            int days = attendance.get(student);

            if (days < 10) {
                System.out.println(student + " -> " + days + " days");
            }
        }

        // Print full attendance table
        System.out.println("\n----- Final Attendance Count -----");
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " days");
        }
    }
}
