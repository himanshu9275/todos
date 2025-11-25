import java.util.*;

public class CopyListDemo {

    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        for (Number n : src) {
            dest.add(n);
        }
    }

    public static void main(String[] args) {
        List<Number> dest = new ArrayList<>();
        List<Integer> src = Arrays.asList(10, 20, 30);

        copyList(dest, src);

        System.out.println("Destination list after copy: " + dest);
    }
}
