import java.util.Scanner;

public class StudentMarks2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3]; // [physics, chemistry, maths]
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Input marks into 2D array
        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1));

            System.out.print("Physics: ");
            double p = sc.nextDouble();

            System.out.print("Chemistry: ");
            double c = sc.nextDouble();

            System.out.print("Maths: ");
            double m = sc.nextDouble();

            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Marks cannot be negative. Please re-enter for this student.");
                i--; // repeat this student
                continue;
            }

            marks[i][0] = p;
            marks[i][1] = c;
            marks[i][2] = m;
        }

        // Calculate percentage and grade using the 2D array
        for (int i = 0; i < n; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
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
        System.out.println("\n=== Student Marks Report (2D Array) ===");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("  Physics  : " + marks[i][0]);
            System.out.println("  Chemistry: " + marks[i][1]);
            System.out.println("  Maths    : " + marks[i][2]);
            System.out.println("  Percentage: " + percentage[i] + "%");
            System.out.println("  Grade    : " + grade[i]);
            System.out.println();
        }
    }
}
