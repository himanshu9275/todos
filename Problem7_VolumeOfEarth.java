public class Problem7_VolumeOfEarth {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double volumeKm3 = (4.0/3) * 3.14159 * Math.pow(radiusKm,3);
        double volumeMiles3 = (4.0/3) * 3.14159 * Math.pow(radiusKm/1.6,3);
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm3 + " and cubic miles is " + volumeMiles3);
    }
}