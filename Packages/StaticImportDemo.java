import static java.lang.Math.*;

public class StaticImportDemo {
    public static void main(String[] args) {
        double a = -25.0;
        double b = 16.0;

        System.out.println("abs(a) = " + abs(a));
        System.out.println("sqrt(b) = " + sqrt(b));
        System.out.println("pow(2,5) = " + pow(2,5));
        System.out.println("max(10,20) = " + max(10,20));
        System.out.println("min(10,20) = " + min(10,20));
    }
}
