import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] heights = new double[11];
        double sum = 0.0;

        System.out.println("Enter the heights (in cm) of 11 players:");

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Height of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }

        double mean = sum / 11.0;

        System.out.println("The mean height of the football team is: " + mean + " cm");
    }
}
