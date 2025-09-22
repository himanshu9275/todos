import java.util.Scanner;
public class Problem10_HeightConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height in cm: ");
        double cm = sc.nextDouble();
        double inches = cm / 2.54;
        int feet = (int)(inches / 12);
        inches = inches % 12;
        System.out.println("Your Height in cm is " + cm + " while in feet is " + feet + " and inches is " + inches);
        sc.close();
    }
}