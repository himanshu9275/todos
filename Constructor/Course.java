class Course {
    // Instance variables
    private String courseName;
    private int duration; // duration in months
    private double fee;

    // Class variable
    private static String instituteName = "Tech Academy";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: ₹" + fee);
    }

    // Class method
    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

// Test Class
public class CourseManagementDemo {
    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 4, 12000);
        Course c2 = new Course("Cybersecurity", 6, 18000);

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        System.out.println("\nUpdating Institute Name...\n");
        Course.updateInstituteName("Code Academy");

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}
