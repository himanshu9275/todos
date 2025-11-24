import java.util.Scanner;

public class TeamBMI2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; // [weight, heightCm, BMI]
        String[] weightStatus = new String[number];

        // Input weight and height
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for person " + (i + 1));

            System.out.print("Weight (kg): ");
            double weight = sc.nextDouble();

            System.out.print("Height (cm): ");
            double heightCm = sc.nextDouble();

            // Validation: no negative or zero values
            if (weight <= 0 || heightCm <= 0) {
                System.out.println("Invalid input. Weight and height must be positive. Please re-enter.");
                i--; // repeat this person
                continue;
            }

            personData[i][0] = weight;
            personData[i][1] = heightCm;
        }

        // Calculate BMI and weight status
        for (int i = 0; i < number; i++) {
            double weight = personData[i][0];
            double heightCm = personData[i][1];
            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);
            personData[i][2] = bmi;

            // Determine weight status (simple standard ranges)
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\n=== BMI Report ===");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("  Weight: " + personData[i][0] + " kg");
            System.out.println("  Height: " + personData[i][1] + " cm");
            System.out.println("  BMI   : " + personData[i][2]);
            System.out.println("  Status: " + weightStatus[i]);
            System.out.println();
        }
    }
}
