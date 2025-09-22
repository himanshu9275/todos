import java.util.Scanner;
public class Problem12_AreaTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter height: ");
        double height = sc.nextDouble();
        double areaInches = 0.5 * base * height;
        double areaCm = areaInches * 6.4516;
        System.out.println("The area of triangle is " + areaInches + " square inches and " + areaCm + " square cm");
        sc.close();
    }
}