// 5. Volume of a Cylinder
import java.util.Scanner;

public class volumeofcylinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        double height = scanner.nextDouble();
        double volume = Math.PI * radius * radius * height;
        System.out.println("Volume: " + volume);
    }
}

