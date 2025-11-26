// Parent Class
class Student {
    public int rollNumber;          // accessible everywhere
    protected String name;          // accessible in subclass
    private double CGPA;            // accessible only inside Student class

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public getter method (to access private CGPA)
    public double getCGPA() {
        return CGPA;
    }

    // Public setter method (to modify private CGPA)
    public void setCGPA(double CGPA) {
        if (CGPA >= 0 && CGPA <= 10)
            this.CGPA = CGPA;
        else
            System.out.println("Invalid CGPA!");
    }

    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass demonstrating access to protected 'name'
class PostgraduateStudent extends Student {

    private String thesisTopic;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String thesisTopic) {
        super(rollNumber, name, CGPA);
        this.thesisTopic = thesisTopic;
    }

    public void showPGStudentDetails() {
        // Accessing protected member: ALLOWED
        System.out.println("PG Student Name (protected): " + name);
        System.out.println("Thesis Topic: " + thesisTopic);
    }
}

// Test class
public class UniversityDemo {
    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Rahul Sharma", 8.7, "Machine Learning");

        pg.displayDetails();            // accessing public method
        pg.showPGStudentDetails();      // demonstrates protected access

        pg.setCGPA(9.1);                // modify private data using setter
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}
