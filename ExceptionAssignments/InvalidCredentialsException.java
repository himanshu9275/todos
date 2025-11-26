public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String msg) { super(msg); }
}

public class LoginSystem {
    static void validate(String user, String pass) throws InvalidCredentialsException {
        String validUser = "admin", validPass = "pass123";
        if (!validUser.equals(user) || !validPass.equals(pass)) throw new InvalidCredentialsException("Invalid username or password");
    }

    public static void main(String[] args) {
        try {
            validate("admin", "wrong");
        } catch (InvalidCredentialsException e) {
            System.out.println("Login failed: " + e.getMessage() + ". Please try again.");
        }
    }
}
