public interface Exportable {
    void exportToCSV();
    void exportToPDF();

    default String exportToJSON() {
        // default simple JSON stub
        System.out.println("Default exportToJSON called");
        return "{}";
    }
}

class Report implements Exportable {
    @Override public void exportToCSV() { System.out.println("CSV exported"); }
    @Override public void exportToPDF() { System.out.println("PDF exported"); }
}

public class ExportDemo {
    public static void main(String[] args) {
        Exportable r = new Report();
        r.exportToCSV();
        r.exportToJSON(); // default used
    }
}
