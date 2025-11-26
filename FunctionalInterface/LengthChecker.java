import java.util.function.Function;

public class LengthChecker {
    public static void main(String[] args) {
        Function<String, Integer> len = s -> s == null ? 0 : s.length();
        String msg = "Hello, this is a test message.";
        System.out.println("Length = " + len.apply(msg));
    }
}
