class Student {
    String name;
    int rollNumber;
    double marks;

    // Method to calculate grade based on marks
    String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    // Method to display student details along with grade
    void displayDetails() {
        System.out.println("Student Name  : " + name);
        System.out.println("Roll Number   : " + rollNumber);
        System.out.println("Marks         : " + marks);
        System.out.println("Grade         : " + calculateGrade());
    }
}

public class StudentReportTest {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Harsh Verma";
        s.rollNumber = 1201;
        s.marks = 87.5;

        s.displayDetails();
    }
}
