import com.company.analytics.sales.SalesReport;
import com.company.analytics.hr.EmployeeReport;

public class AnalyticsMain {
    public static void main(String[] args) {
        SalesReport sr = new SalesReport();
        EmployeeReport er = new EmployeeReport();

        System.out.println("=== Company Combined Report ===");
        sr.printSales();
        er.printEmployeePerformance();
    }
}
