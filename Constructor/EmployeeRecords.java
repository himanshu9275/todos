// Parent Class
class Employee {
    public int employeeID;        // public
    protected String department;  // protected
    private double salary;        // private

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary (encapsulation)
    public void setSalary(double salary) {
        if (salary > 0)
            this.salary = salary;
        else
            System.out.println("Invalid salary!");
    }

    // Public method to view salary (getter)
    public double getSalary() {
        return salary;
    }

    public void showEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

// Subclass Manager demonstrating access to public + protected
class Manager extends Employee {
    private String teamName;

    public Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    public void showManagerDetails() {
        // Accessing public employeeID: ✔ allowed
        System.out.println("Manager Employee ID: " + employeeID);

        // Accessing protected department: ✔ allowed
        System.out.println("Manager Department: " + department);

        System.out.println("Team Name: " + teamName);

        // Accessing private salary is NOT allowed directly — must use getter
        System.out.println("Manager Salary: " + getSalary());
    }
}

// Test Class
public class EmployeeDemo {
    public static void main(String[] args) {
        Manager m = new Manager(1001, "IT", 85000, "Backend Team");

        m.showEmployeeDetails();
        System.out.println();
        m.showManagerDetails();

        // Modify salary using public method
        m.setSalary(90000);
        System.out.println("\nUpdated Salary: " + m.getSalary());
    }
}
