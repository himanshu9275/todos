import java.util.*;

public class GradeParser {
    public static void main(String[] args) {
        String[] grades = {"90", "A+", "85", "100", "B"};
        for (String g : grades) {
            try {
                int val = Integer.parseInt(g);
                System.out.println("Parsed grade: " + val);
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade input: " + g);
            }
        }
    }
}
