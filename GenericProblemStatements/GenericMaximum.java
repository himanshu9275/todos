public class GenericMaximum {

    // Generic method with bounded type parameter
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {

        T max = x;  // assume x is largest

        if (y.compareTo(max) > 0)
            max = y;

        if (z.compareTo(max) > 0)
            max = z;

        return max;
    }

    public static void main(String[] args) {
        System.out.println("Max of 3, 7, 5   = " + maximum(3, 7, 5));
        System.out.println("Max of 7.5, 2.9, 5.1 = " + maximum(7.5, 2.9, 5.1));
        System.out.println("Max of A, T, K = " + maximum("A", "T", "K"));
    }
}
