class Circle {
    double radius;

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    void displayInfo() {
        System.out.println("Radius        : " + radius);
        System.out.println("Area          : " + calculateArea());
        System.out.println("Circumference : " + calculateCircumference());
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.radius = 7.5;

        c.displayInfo();
    }
}
