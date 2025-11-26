public class WrapperToPrimitive {
    public static void main(String[] args) {
        Double d = 45.67;

        double primitiveDouble = d.doubleValue();
        int asInt = (int) primitiveDouble; // cast

        System.out.println("Double object: " + d);
        System.out.println("double primitive: " + primitiveDouble);
        System.out.println("int (cast): " + asInt);
    }
}
