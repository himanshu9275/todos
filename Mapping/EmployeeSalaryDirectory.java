import java.util.*;

public class EmployeeSalaryDirectory {

    // Method to give raise by percentage
    public static void giveRaise(Map<String, Double> map, String name, double percent) {
        if (!map.containsKey(name)) {
            System.out.println("Employee not found: " + name);
            return;
        }

        double oldSalary = map.get(name);
        double newSalary = oldSalary + (oldSalary * percent / 100);

        map.put(name, newSalary);
        System.out.println(name + "'s salary increased from " + oldSalary + " to " + newSalary);
    }

    public static void main(String[] args) {

        Map<String, Double> salaries = new HashMap<>();

        // 1. Add employees
        salaries.put("Amit", 45000.0);
        salaries.put("Riya", 55000.0);
        salaries.put("Sumit", 38000.0);
        salaries.put("Neha", 61000.0);
        salaries.put("Karan", 42000.0);
        salaries.put("Pooja", 61000.0);

        // 2. Give raises
        giveRaise(salaries, "Amit", 10);
        giveRaise(salaries, "Neha", 5);
        giveRaise(salaries, "Karan", 20);
        giveRaise(salaries, "Unknown", 10); // should show not found

        // 3. Calculate average salary
        double total = 0;
        for (double sal : salaries.values()) {
            total += sal;
        }
        double average = total / salaries.size();

        // 4. Find highest salary
        double maxSalary = Collections.max(salaries.values());

        System.out.println("\n---- Employee Salaries ----");
        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nAverage Salary: " + average);

        System.out.println("\nHighest Paid Employee(s): ");
        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            if (entry.getValue() == maxSalary) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}
