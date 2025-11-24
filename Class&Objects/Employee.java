class Employee {
    String name;
    int id;
    double salary;

    void displayDetails() {
        System.out.println("Employee Name  : " + name);
        System.out.println("Employee ID    : " + id);
        System.out.println("Employee Salary: " + salary);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.name = "Rahul Kumar";
        emp.id = 101;
        emp.salary = 45000.50;

        emp.displayDetails();
    }
}
