public class SpringSeasonProgram {

    // Method to check for Spring season
    public static boolean isSpring(int month, int day) {
        // March 20–31
        if (month == 3 && day >= 20 && day <= 31) return true;
        // April 1–30
        if (month == 4 && day >= 1 && day <= 30) return true;
        // May 1–31
        if (month == 5 && day >= 1 && day <= 31) return true;
        // June 1–20
        if (month == 6 && day >= 1 && day <= 20) return true;

        return false;
    }

    public static void main(String[] args) {
        // Expect args[0] = month, args[1] = day
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        if (isSpring(month, day)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
