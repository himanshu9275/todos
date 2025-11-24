import java.util.Scanner;

public class ZaraBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] newSalary = new double[10];
        double[] bonus = new double[10];

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        // Input: salary and years of service
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for employee " + (i + 1));

            System.out.print("Salary: ");
            double s = sc.nextDouble();

            System.out.print("Years of service: ");
            double y = sc.nextDouble();

            // Validate
            if (s <= 0 || y < 0) {
                System.out.println("Invalid salary or years of service. Please re-enter.");
                i--; // repeat this index
                continue;
            }

            salary[i] = s;
            yearsOfService[i] = y;
        }

        // Calculate bonus, new salary, and totals
        for (int i = 0; i < 10; i++) {
            double rate;
            if (yearsOfService[i] > 5) {
                rate = 0.05; // 5%
            } else {
                rate = 0.02; // 2%
            }

            bonus[i] = salary[i] * rate;
            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("\n=== Zara Bonus Summary ===");
        System.out.println("Total old salary of all employees: " + totalOldSalary);
        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total new salary of all employees: " + totalNewSalary);
    }
}
