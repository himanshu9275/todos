import java.util.*;

// ---------------------------
// MedicalRecord Interface
// ---------------------------
interface MedicalRecord {
    /**
     * Add a medical record entry (diagnosis, notes) for the patient.
     */
    void addRecord(String entry);

    /**
     * View records with role-based access:
     * - "doctor" sees full entries
     * - "nurse" sees limited/summary information
     * - any other role sees a masked/permission-denied summary
     */
    List<String> viewRecords(String role);
}

// ---------------------------
// Abstract Patient
// ---------------------------
abstract class Patient implements MedicalRecord {
    private final String patientId;
    private String name;
    private int age;

    // Sensitive data — encapsulated
    private final List<String> medicalHistory = new ArrayList<>(); // full text kept private

    public Patient(String patientId, String name, int age) {
        if (patientId == null || patientId.trim().isEmpty()) throw new IllegalArgumentException("Invalid patientId");
        setName(name);
        setAge(age);
        this.patientId = patientId.trim();
    }

    public String getPatientId() { return patientId; }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Invalid name");
        this.name = name.trim();
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    // Abstract billing method
    public abstract double calculateBill();

    // Concrete method to display public patient details (no sensitive history)
    public String getPatientDetails() {
        return String.format("PatientID: %s | Name: %s | Age: %d | Type: %s",
                patientId, name, age, this.getClass().getSimpleName());
    }

    // MedicalRecord API: addRecord and viewRecords control access to medicalHistory
    @Override
    public void addRecord(String entry) {
        if (entry == null || entry.trim().isEmpty()) throw new IllegalArgumentException("Record cannot be empty");
        medicalHistory.add(String.format("[%s] %s", new Date(), entry.trim()));
    }

    @Override
    public List<String> viewRecords(String role) {
        // Return a copy / view depending on role
        List<String> result = new ArrayList<>();
        if ("doctor".equalsIgnoreCase(role)) {
            // doctor sees everything
            result.addAll(medicalHistory);
        } else if ("nurse".equalsIgnoreCase(role)) {
            // nurse sees a short summary: only the first 50 chars of each entry
            for (String e : medicalHistory) {
                result.add(shorten(e));
            }
        } else {
            // others: deny detail but show a non-sensitive note
            result.add("Access Restricted: Contact attending physician for details.");
        }
        return result;
    }

    // Helper: shorten/mask entry
    private String shorten(String s) {
        if (s.length() <= 50) return s;
        return s.substring(0, 47) + "...";
    }
}

// ---------------------------
// InPatient: stays in hospital (room charges + treatment fees + service)
// ---------------------------
class InPatient extends Patient {
    private int daysAdmitted;
    private double roomRatePerDay;
    private double treatmentCharges; // tests/procedures

    public InPatient(String patientId, String name, int age, int daysAdmitted, double roomRatePerDay, double treatmentCharges) {
        super(patientId, name, age);
        setDaysAdmitted(daysAdmitted);
        setRoomRatePerDay(roomRatePerDay);
        setTreatmentCharges(treatmentCharges);
    }

    public int getDaysAdmitted() { return daysAdmitted; }
    public void setDaysAdmitted(int daysAdmitted) {
        if (daysAdmitted < 0) throw new IllegalArgumentException("Days admitted cannot be negative");
        this.daysAdmitted = daysAdmitted;
    }

    public double getRoomRatePerDay() { return roomRatePerDay; }
    public void setRoomRatePerDay(double roomRatePerDay) {
        if (roomRatePerDay < 0) throw new IllegalArgumentException("Room rate cannot be negative");
        this.roomRatePerDay = roomRatePerDay;
    }

    public double getTreatmentCharges() { return treatmentCharges; }
    public void setTreatmentCharges(double treatmentCharges) {
        if (treatmentCharges < 0) throw new IllegalArgumentException("Treatment charges cannot be negative");
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        // Bill = room charges + treatment charges + service fee (10% of treatment)
        double room = daysAdmitted * roomRatePerDay;
        double service = treatmentCharges * 0.10; // 10% service
        return room + treatmentCharges + service;
    }
}

// ---------------------------
// OutPatient: consultation + tests + medicines
// ---------------------------
class OutPatient extends Patient {
    private double consultationFee;
    private double testCharges;
    private double medicineCharges;

    public OutPatient(String patientId, String name, int age, double consultationFee, double testCharges, double medicineCharges) {
        super(patientId, name, age);
        setConsultationFee(consultationFee);
        setTestCharges(testCharges);
        setMedicineCharges(medicineCharges);
    }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) {
        if (consultationFee < 0) throw new IllegalArgumentException("Consultation fee cannot be negative");
        this.consultationFee = consultationFee;
    }

    public double getTestCharges() { return testCharges; }
    public void setTestCharges(double testCharges) {
        if (testCharges < 0) throw new IllegalArgumentException("Test charges cannot be negative");
        this.testCharges = testCharges;
    }

    public double getMedicineCharges() { return medicineCharges; }
    public void setMedicineCharges(double medicineCharges) {
        if (medicineCharges < 0) throw new IllegalArgumentException("Medicine charges cannot be negative");
        this.medicineCharges = medicineCharges;
    }

    @Override
    public double calculateBill() {
        // Bill = consultation + tests + medicines + small service fee (5% of tests)
        double service = testCharges * 0.05;
        return consultationFee + testCharges + medicineCharges + service;
    }
}

// ---------------------------
// Demo / Main
// ---------------------------
public class HospitalPatientManagementDemo {
    public static void main(String[] args) {
        // Create patients
        InPatient ip1 = new InPatient("IP1001", "Aarti Verma", 45, 5, 3000.0, 15000.0);
        InPatient ip2 = new InPatient("IP1002", "Rohan Gupta", 60, 12, 2500.0, 40000.0);

        OutPatient op1 = new OutPatient("OP2001", "Deepa Singh", 30, 800.0, 1200.0, 250.0);
        OutPatient op2 = new OutPatient("OP2002", "Karan Patel", 22, 600.0, 0.0, 100.0);

        // Add medical records (sensitive) via controlled API
        ip1.addRecord("Admitted with chest pain; ECG and troponin done. Diagnosed acute MI. Started on thrombolytics.");
        ip1.addRecord("Underwent angioplasty day 2; ICU monitoring. Stable.");

        ip2.addRecord("Hip replacement surgery performed. Post-op physiotherapy advised.");
        op1.addRecord("General checkup; advised vitamins and lifestyle changes.");
        op2.addRecord("Minor cut; wound dressing and tetanus prophylaxis.");

        // Put into a list of Patient to demonstrate polymorphism
        List<Patient> patients = Arrays.asList(ip1, ip2, op1, op2);

        // Display public details and compute bills
        System.out.println("=== Patient Billing Summary ===");
        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());
            System.out.printf("  Calculated Bill: ₹%.2f%n", p.calculateBill());

            // Show medical records for nurse role (limited)
            System.out.println("  Records (nurse view):");
            List<String> nurseView = p.viewRecords("nurse");
            nurseView.forEach(r -> System.out.println("    " + r));

            // Show doctor view (full)
            System.out.println("  Records (doctor view):");
            List<String> docView = p.viewRecords("doctor");
            docView.forEach(r -> System.out.println("    " + r));

            System.out.println("--------------------------------------");
        }

        // Attempt unauthorized view
        System.out.println("=== Unauthorized Access Attempt ===");
        List<String> visitorView = ip1.viewRecords("receptionist");
        visitorView.forEach(s -> System.out.println("  " + s));

        System.out.println("\nDemo complete.");
    }
}
