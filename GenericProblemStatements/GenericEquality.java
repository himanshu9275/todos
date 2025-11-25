public class GenericEquality {

    // Generic Method
    public static <T> boolean isEqual(T a, T b) {
        return a.equals(b);
    }

    public static void main(String[] args) {
        System.out.println(isEqual(10, 10));           // true
        System.out.println(isEqual("Hello", "Hello")); // true
        System.out.println(isEqual(4.5, 3.2));         // false
    }
}
