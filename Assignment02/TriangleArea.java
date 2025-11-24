import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base (cm): ");
        float base = sc.nextFloat();

        System.out.print("Enter height (cm): ");
        float height = sc.nextFloat();

        float areaSqCm = 0.5f * base * height;
        float areaSqIn = areaSqCm / (2.54f * 2.54f);

        System.out.println("The Area of the triangle in sq in is " + areaSqIn 
                           + " and sq cm is " + areaSqCm);
    }
}
