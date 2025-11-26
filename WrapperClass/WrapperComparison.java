public class WrapperComparison {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        System.out.println("a == b : " + (a == b));           // usually true (cached -128..127)
        System.out.println("c == d : " + (c == d));           // usually false (outside cache)
        System.out.println("a.equals(b) : " + a.equals(b));   // true

        System.out.println("\nExplanation: Integer values between -128 and 127 are cached by Integer.valueOf(), so references may be the same for small ints. equals() checks value equality.");
    }
}
