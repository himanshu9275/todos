import java.time.*;

class LateSubmissionException extends Exception { LateSubmissionException(String m){super(m);} }
class InvalidFileFormatException extends Exception { InvalidFileFormatException(String m){super(m);} }

public class ExamSubmission {
    static final LocalDateTime DEADLINE = LocalDateTime.of(2025, 12, 1, 23, 59);

    static void submitExam(String fileName, LocalDateTime submissionTime) throws LateSubmissionException, InvalidFileFormatException {
        if (!fileName.endsWith(".pdf")) throw new InvalidFileFormatException("File must be .pdf");
        if (submissionTime.isAfter(DEADLINE)) throw new LateSubmissionException("Submission is late");
        System.out.println("Submission successful.");
    }

    public static void main(String[] args) {
        try {
            submitExam("answer.docx", LocalDateTime.now());
        } catch (InvalidFileFormatException e) {
            System.out.println("Submission failed: invalid file format");
        } catch (LateSubmissionException e) {
            System.out.println("Submission failed: late submission");
        }
    }
}
