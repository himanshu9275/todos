// 4. Area of a Circle
import java.util.Scanner;

public class areaofcircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        double area = Math.PI * radius * radius;
        System.out.println("Area: " + area);
    }
}
