public interface SecurityUtils {
    static boolean isStrongPassword(String pw) {
        if (pw == null) return false;
        return pw.length() >= 8 &&
               pw.matches(".*[A-Z].*") &&
               pw.matches(".*[a-z].*") &&
               pw.matches(".*\\d.*") &&
               pw.matches(".*[^A-Za-z0-9].*");
    }
}

// Demo
public class PasswordDemo {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrongPassword("Abc@1234")); // true
        System.out.println(SecurityUtils.isStrongPassword("weak"));     // false
    }
}
