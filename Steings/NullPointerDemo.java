public class NullPointerDemo {
    
    public static void generateNullPointer() {
        String text = null;   // explicitly null

        // This will cause NullPointerException
        System.out.println("Length of text is: " + text.length());
    }

    public static void main(String[] args) {
        try {
            generateNullPointer();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: You tried to use a null reference.");
        }
    }
}
