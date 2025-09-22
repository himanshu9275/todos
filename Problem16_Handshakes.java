import java.util.Scanner;
public class Problem16_Handshakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int handshakes = (n * (n - 1)) / 2;
        System.out.println("Maximum number of possible handshakes is " + handshakes);
        sc.close();
    }
}