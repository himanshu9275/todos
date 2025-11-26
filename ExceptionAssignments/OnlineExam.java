import java.io.IOException;

class InvalidStudentException extends Exception { InvalidStudentException(String m){super(m);} }

public class OnlineExam {
    static void validateStudent(boolean valid) throws InvalidStudentException {
        if (!valid) throw new InvalidStudentException("Student validation failed");
    }

    static void submitExam(boolean valid) throws InvalidStudentException, IOException {
        validateStudent(valid);
        // simulate possible IOException
        if (!valid) throw new IOException("I/O error during submission");
        System.out.println("Exam submitted");
    }

    public static void main(String[] args) {
        try {
            submitExam(false);
        } catch (InvalidStudentException e) {
            System.out.println("Validation error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } finally {
            System.out.println("Exam submission process completed.");
        }
    }
}
