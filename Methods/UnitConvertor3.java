public class UnitConvertor3 {

    // Fahrenheit ↔ Celsius
    public static double convertFarhenheitToCelsius(double fahrenheit) {
        double farhenheit2celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return farhenheit2celsius;
    }

    public static double convertCelsiusToFarhenheit(double celsius) {
        double celsius2farhenheit = (celsius * 9.0 / 5.0) + 32;
        return celsius2farhenheit;
    }

    // Pounds ↔ Kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kg) {
        double kilograms2pounds = 2.20462;
        return kg * kilograms2pounds;
    }

    // Gallons ↔ Liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
}
