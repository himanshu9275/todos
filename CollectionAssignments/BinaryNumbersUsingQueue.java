import java.util.*;

public class BinaryNumbersUsingQueue {

    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("1");

        for (int i = 0; i < n; i++) {
            String front = q.remove();
            result.add(front);

            q.add(front + "0");
            q.add(front + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("Binary Numbers: " + generateBinary(N));
    }
}
