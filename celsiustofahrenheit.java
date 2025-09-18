// 3. Celsius to Fahrenheit Conversion
import java.util.Scanner;

public class celsiustofahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double celsius = scanner.nextDouble();
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Fahrenheit: " + fahrenheit);
    }
}

