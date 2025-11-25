import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ===== Base abstract class for all job roles =====
abstract class JobRole {
    String candidateName;
    double yearsOfExperience;
    double score;  // simple "AI score" for demo

    public JobRole(String candidateName, double yearsOfExperience) {
        this.candidateName = candidateName;
        this.yearsOfExperience = yearsOfExperience;
    }

    public abstract String getRoleName();

    // Each role can have its own scoring logic
    public abstract void computeScore();

    @Override
    public String toString() {
        return getRoleName() + " - " + candidateName +
                " (" + yearsOfExperience + " yrs, score=" + score + ")";
    }
}

// ===== Specific job roles =====
class SoftwareEngineer extends JobRole {
    int numberOfProjects;

    public SoftwareEngineer(String candidateName, double yearsOfExperience, int numberOfProjects) {
        super(candidateName, yearsOfExperience);
        this.numberOfProjects = numberOfProjects;
        computeScore();
    }

    @Override
    public String getRoleName() {
        return "Software Engineer";
    }

    @Override
    public void computeScore() {
        // Very simple scoring logic just for demonstration
        this.score = yearsOfExperience * 2 + numberOfProjects * 1.5;
    }
}

class DataScientist extends JobRole {
    int numberOfMLModels;

    public DataScientist(String candidateName, double yearsOfExperience, int numberOfMLModels) {
        super(candidateName, yearsOfExperience);
        this.numberOfMLModels = numberOfMLModels;
        computeScore();
    }

    @Override
    public String getRoleName() {
        return "Data Scientist";
    }

    @Override
    public void computeScore() {
        this.score = yearsOfExperience * 2.5 + numberOfMLModels * 2;
    }
}

class ProductManager extends JobRole {
    int productsManaged;

    public ProductManager(String candidateName, double yearsOfExperience, int productsManaged) {
        super(candidateName, yearsOfExperience);
        this.productsManaged = productsManaged;
        computeScore();
    }

    @Override
    public String getRoleName() {
        return "Product Manager";
    }

    @Override
    public void computeScore() {
        this.score = yearsOfExperience * 2 + productsManaged * 3;
    }
}

// ===== Generic Resume class =====
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void displayResume() {
        System.out.println("Resume: " + jobRole);
    }

    // Example of a generic method inside a generic class (bounded type)
    public static <R extends JobRole> R selectBestCandidate(List<R> candidates) {
        if (candidates.isEmpty()) return null;
        R best = candidates.get(0);
        for (R c : candidates) {
            if (c.score > best.score) {
                best = c;
            }
        }
        return best;
    }
}

// ===== Utility class with wildcard methods =====
class ResumeScreeningUtils {

    // Wildcard method: handle List<? extends JobRole>
    public static void processAllResumes(List<? extends JobRole> candidates) {
        System.out.println("Processing " + candidates.size() + " resumes:");
        for (JobRole jr : candidates) {
            System.out.println(" - " + jr);
        }
    }

    // Generic method with bounded type parameter
    public static <T extends JobRole> void printTopCandidate(List<T> candidates) {
        if (candidates.isEmpty()) {
            System.out.println("No candidates.");
            return;
        }
        T top = candidates.get(0);
        for (T c : candidates) {
            if (c.score > top.score) {
                top = c;
            }
        }
        System.out.println("Top candidate for " + top.getRoleName() + ": " + top);
    }
}

// ===== Demo main class =====
public class AIResumeScreeningDemo {
    public static void main(String[] args) {

        // Create resumes for different roles
        SoftwareEngineer se1 = new SoftwareEngineer("Alice", 3, 5);
        SoftwareEngineer se2 = new SoftwareEngineer("Bob", 5, 8);

        DataScientist ds1 = new DataScientist("Charlie", 4, 6);
        DataScientist ds2 = new DataScientist("Disha", 2, 4);

        ProductManager pm1 = new ProductManager("Ethan", 6, 3);
        ProductManager pm2 = new ProductManager("Fatima", 4, 5);

        // Wrap them in Resume<T>
        Resume<SoftwareEngineer> seResume1 = new Resume<>(se1);
        Resume<SoftwareEngineer> seResume2 = new Resume<>(se2);
        Resume<DataScientist> dsResume1 = new Resume<>(ds1);
        Resume<ProductManager> pmResume1 = new Resume<>(pm1);

        System.out.println("=== Display individual resumes ===");
        seResume1.displayResume();
        seResume2.displayResume();
        dsResume1.displayResume();
        pmResume1.displayResume();

        // Lists of candidates by role
        List<SoftwareEngineer> seList = Arrays.asList(se1, se2);
        List<DataScientist> dsList = Arrays.asList(ds1, ds2);
        List<ProductManager> pmList = Arrays.asList(pm1, pm2);

        System.out.println("\n=== Process all Software Engineer resumes (wildcard method) ===");
        ResumeScreeningUtils.processAllResumes(seList);

        System.out.println("\n=== Process all Data Scientist resumes (wildcard method) ===");
        ResumeScreeningUtils.processAllResumes(dsList);

        System.out.println("\n=== Top candidate per role (generic method) ===");
        ResumeScreeningUtils.printTopCandidate(seList);
        ResumeScreeningUtils.printTopCandidate(dsList);
        ResumeScreeningUtils.printTopCandidate(pmList);

        System.out.println("\n=== Using Resume.selectBestCandidate generic method ===");
        SoftwareEngineer bestSE = Resume.selectBestCandidate(seList);
        System.out.println("Best Software Engineer: " + bestSE);

        DataScientist bestDS = Resume.selectBestCandidate(dsList);
        System.out.println("Best Data Scientist: " + bestDS);
    }
}
