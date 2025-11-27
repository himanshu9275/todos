import java.util.*;

public class FrequencyCount {
    public static Map<String, Integer> frequency(List<String> list) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String item : list) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple","banana","apple","orange");
        System.out.println("List: " + items);
        System.out.println("Frequency: " + frequency(items));
    }
}
