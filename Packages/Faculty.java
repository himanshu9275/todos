package college.faculty;

public class Faculty {
    private String facultyName;
    private String subject;

    public Faculty(String facultyName, String subject) {
        this.facultyName = facultyName;
        this.subject = subject;
    }

    public void showFaculty() {
        System.out.println("Faculty Name: " + facultyName);
        System.out.println("Subject      : " + subject);
        System.out.println("------------------------------------");
    }
}
