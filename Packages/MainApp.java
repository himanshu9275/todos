package college.main;

import college.student.Student;
import college.faculty.Faculty;
import college.department.Department;

import static java.lang.Math.*;  // static import example

public class MainApp {
    public static void main(String[] args) {

        System.out.println("==== College Management System ====\n");

        // Student Objects
        Student s1 = new Student("Amit Sharma", 101);
        Student s2 = new Student("Priya Verma", 102);

        // Faculty Objects
        Faculty f1 = new Faculty("Dr. Mehta", "Computer Science");
        Faculty f2 = new Faculty("Prof. Gupta", "Mathematics");

        // Department Objects
        Department d1 = new Department("CSE", 120);
        Department d2 = new Department("ECE", 90);

        // Display Everything
        System.out.println("---- Students ----");
        s1.showStudent();
        s2.showStudent();

        System.out.println("---- Faculties ----");
        f1.showFaculty();
        f2.showFaculty();

        System.out.println("---- Departments ----");
        d1.showDepartment();
        d2.showDepartment();

        // Example of static import usage
        System.out.println("Static Import Example: pow(3,3) = " + pow(3,3));
    }
}
