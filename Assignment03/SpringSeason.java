public class SpringSeason {
    public static void main(String[] args) {
        int month = Integer.parseInt(args[0]); // e.g. 3 for March
        int day   = Integer.parseInt(args[1]); // e.g. 21

        boolean isSpring =
            (month == 3 && day >= 20 && day <= 31) ||  // March 20–31
            (month == 4 && day >= 1  && day <= 30) ||  // April
            (month == 5 && day >= 1  && day <= 31) ||  // May
            (month == 6 && day >= 1  && day <= 20);    // June 1–20

        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
