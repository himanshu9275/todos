import java.util.*;

public class PatientIdPrinter {
    public static void main(String[] args) {
        List<String> patientIds = Arrays.asList("P001", "P002", "P003", "P004");

        // Method reference to print each ID
        patientIds.forEach(System.out::println);
    }
}
