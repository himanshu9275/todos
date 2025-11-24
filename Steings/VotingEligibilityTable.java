import java.util.Scanner;

public class VotingEligibilityTable {

    // Generate random 2-digit ages for n students
    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            // Random age between 10 and 99 (2-digit)
            ages[i] = (int) (Math.random() * 90) + 10;
        }
        return ages;
    }

    // Build 2D array: [age, canVoteTrueFalse]
    public static String[][] buildVotingTable(int[] ages) {
        String[][] table = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            boolean canVote;

            if (age < 0) {
                canVote = false; // invalid age, cannot vote
            } else if (age >= 18) {
                canVote = true;
            } else {
                canVote = false;
            }

            table[i][0] = String.valueOf(age);
            table[i][1] = String.valueOf(canVote);
        }

        return table;
    }

    // Display 2D table
    public static void displayTable(String[][] table) {
        System.out.println("Student\tAge\tCan Vote?");
        System.out.println("---------------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.println((i + 1) + "\t" + table[i][0] + "\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students (e.g., 10): ");
        int n = sc.nextInt();

        int[] ages = generateRandomAges(n);
        String[][] votingTable = buildVotingTable(ages);

        displayTable(votingTable);
    }
}
