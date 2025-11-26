public class BankLimit {
    public static double remainingLimit(Double limit, double used) {
        if (limit == null) return 0.0;
        return Math.max(0.0, limit - used);
    }

    public static void main(String[] args) {
        System.out.println(remainingLimit(5000.0, 1200.0)); // 3800.0
        System.out.println(remainingLimit(null, 100));     // 0.0
    }
}
