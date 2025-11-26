// Sensitive.java (marker)
public interface Sensitive {}

// UserData.java
class UserData implements Sensitive {
    String name; String ssn;
    UserData(String n, String s){ name=n; ssn=s; }
}

// Processor
public class SensitiveDemo {
    public static void main(String[] args) {
        UserData u = new UserData("Alice", "123-45-6789");
        if (u instanceof Sensitive) {
            System.out.println("Encrypting sensitive data for " + u.name);
        } else {
            System.out.println("No encryption needed");
        }
    }
}
