public class Problem4_ProfitLoss {
    public static void main(String[] args) {
        int cost = 129, sell = 191;
        int profit = sell - cost;
        double percent = (profit * 100.0) / cost;
        System.out.println("The Cost Price is INR " + cost + " and Selling Price is INR " + sell + "\nThe Profit is INR " + profit + " and the Profit Percentage is " + percent);
    }
}