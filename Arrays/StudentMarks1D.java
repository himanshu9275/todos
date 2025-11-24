import java.util.Scanner;

public class StudentMarks1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Input marks
        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1));

            System.out.print("Physics: ");
            double p = sc.nextDouble();

            System.out.print("Chemistry: ");
            double c = sc.nextDouble();

            System.out.print("Maths: ");
            double m = sc.nextDouble();

            // Validate marks: must be non-negative
            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Marks cannot be negative. Please re-enter for this student.");
                i--; // repeat this student
                continue;
            }

            physics[i] = p;
            chemistry[i] = c;
            maths[i] = m;
        }

        // Calculate percentage and grade
        for (int i = 0; i < n; i++) {
            double total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = (total / 300.0) * 100.0;

            if (percentage[i] >= 90) {
                grade[i] = 'A';
            } else if (percentage[i] >= 80) {
                grade[i] = 'B';
            } else if (percentage[i] >= 70) {
                grade[i] = 'C';
            } else if (percentage[i] >= 60) {
                grade[i] = 'D';
            } else {
                grade[i] = 'F';
            }
        }

        // Display all details
        System.out.println("\n=== Student Marks Report (1D Arrays) ===");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("  Physics  : " + physics[i]);
            System.out.println("  Chemistry: " + chemistry[i]);
            System.out.println("  Maths    : " + maths[i]);
            System.out.println("  Percentage: " + percentage[i] + "%");
            System.out.println("  Grade    : " + grade[i]);
            System.out.println();
        }
    }
}
