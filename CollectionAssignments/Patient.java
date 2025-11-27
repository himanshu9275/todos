import java.util.*;

class Patient {
    String name;
    int severity;  // higher means more urgent

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriage {

    public static void main(String[] args) {
        PriorityQueue<Patient> pq = new PriorityQueue<>(
                (a, b) -> b.severity - a.severity  // max-heap behavior
        );

        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");
        while (!pq.isEmpty()) {
            Patient p = pq.remove();
            System.out.println(p.name + " (severity " + p.severity + ")");
        }
    }
}
