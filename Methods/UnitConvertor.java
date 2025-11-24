public class UnitConvertor {

    // Convert kilometers to miles
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    // Convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    // Convert meters to feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    // Convert feet to meters
    public static double convertFeetToMeters(double feet) {
        double meters2feet = 3.28084;
        return feet / meters2feet;   // inverse
    }

    // (Optional) Demo main – can be removed if teacher wants only utility methods
    public static void main(String[] args) {
        double km = 5.0;
        double miles = convertKmToMiles(km);
        System.out.println(km + " km = " + miles + " miles");

        double backToKm = convertMilesToKm(miles);
        System.out.println(miles + " miles = " + backToKm + " km");

        double meters = 10.0;
        double feet = convertMetersToFeet(meters);
        System.out.println(meters + " meters = " + feet + " feet");

        double backToMeters = convertFeetToMeters(feet);
        System.out.println(feet + " feet = " + backToMeters + " meters");
    }
}
