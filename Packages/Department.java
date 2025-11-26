package college.department;

public class Department {
    private String deptName;
    private int totalStudents;

    public Department(String deptName, int totalStudents) {
        this.deptName = deptName;
        this.totalStudents = totalStudents;
    }

    public void showDepartment() {
        System.out.println("Department Name : " + deptName);
        System.out.println("Total Students  : " + totalStudents);
        System.out.println("------------------------------------");
    }
}
