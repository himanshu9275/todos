class InvalidTemperatureException extends Exception { InvalidTemperatureException(String m){super(m);} }

public class TempConverter {
    public static double cToF(double c) { return c * 9/5 + 32; }
    public static double fToC(double f) { return (f - 32) * 5/9; }

    static double convert(double value, char unit) throws InvalidTemperatureException {
        if (unit == 'C' && value < -273.15) throw new InvalidTemperatureException("Temperature below absolute zero!");
        if (unit == 'F' && value < -459.67) throw new InvalidTemperatureException("Temperature below absolute zero!");
        return (unit == 'C') ? cToF(value) : fToC(value);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Converted: " + convert(-300, 'C'));
        } catch (InvalidTemperatureException e) {
            System.out.println("Error: Temperature below absolute zero is not possible!");
        }
    }
}
