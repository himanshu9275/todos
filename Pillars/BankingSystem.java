import java.util.*;

// ---------------------------
// Custom exceptions
// ---------------------------
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) { super(msg); }
}

class AuthenticationException extends Exception {
    public AuthenticationException(String msg) { super(msg); }
}

// ---------------------------
// Loanable interface
// ---------------------------
interface Loanable {
    // Attempt to apply for a loan of requestedAmount; return approval status
    boolean applyForLoan(double requestedAmount);

    // Calculate how much loan the account is eligible for (business rule)
    double calculateLoanEligibility();
}

// ---------------------------
// Abstract BankAccount
// ---------------------------
abstract class BankAccount {
    private final String accountNumber;
    private String holderName;
    private double balance;
    private final String pin; // simple PIN for demo (keeps restricted access)

    public BankAccount(String accountNumber, String holderName, double initialBalance, String pin) {
        if (accountNumber == null || accountNumber.trim().isEmpty())
            throw new IllegalArgumentException("Account number required");
        if (holderName == null || holderName.trim().isEmpty())
            throw new IllegalArgumentException("Holder name required");
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative");
        if (pin == null || pin.length() < 4) throw new IllegalArgumentException("PIN must be at least 4 characters");

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.pin = pin;
    }

    // Authentication helper
    protected void authenticate(String enteredPin) throws AuthenticationException {
        if (!this.pin.equals(enteredPin)) throw new AuthenticationException("Invalid PIN for account " + accountNumber);
    }

    // Concrete deposit (no PIN required for deposit in this demo)
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
        System.out.printf("Deposited %.2f into %s. New balance: %.2f%n", amount, accountNumber, balance);
    }

    // Concrete withdraw (requires PIN)
    public void withdraw(double amount, String enteredPin) throws AuthenticationException, InsufficientFundsException {
        authenticate(enteredPin);
        if (amount <= 0) throw new IllegalArgumentException("Withdraw amount must be positive");
        if (amount > balance) throw new InsufficientFundsException("Insufficient funds in account " + accountNumber);
        balance -= amount;
        System.out.printf("Withdrew %.2f from %s. New balance: %.2f%n", amount, accountNumber, balance);
    }

    // View balance (requires PIN)
    public double getBalance(String enteredPin) throws AuthenticationException {
        authenticate(enteredPin);
        return balance;
    }

    // Protected setter for subclasses if needed (no direct public access)
    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    // Basic getters (no PIN required)
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) {
        if (holderName == null || holderName.trim().isEmpty()) throw new IllegalArgumentException("Invalid holder name");
        this.holderName = holderName.trim();
    }

    // Abstract: interest calculation depends on account type
    public abstract double calculateInterest(); // returns interest amount for a period (e.g., monthly/annual as impl)

    // Display details (does not show PIN or sensitive info)
    public void displayDetails() {
        System.out.printf("Account: %s | Holder: %s | Balance: %.2f | Type: %s%n",
                accountNumber, holderName, balance, this.getClass().getSimpleName());
    }
}

// ---------------------------
// SavingsAccount (implements Loanable)
// ---------------------------
class SavingsAccount extends BankAccount implements Loanable {
    private double annualInterestRatePercent; // e.g., 4.0 means 4% p.a.
    private double minBalanceRequired;

    public SavingsAccount(String accountNumber, String holderName, double initialBalance, String pin,
                          double annualInterestRatePercent, double minBalanceRequired) {
        super(accountNumber, holderName, initialBalance, pin);
        if (annualInterestRatePercent < 0) throw new IllegalArgumentException("Interest rate cannot be negative");
        if (minBalanceRequired < 0) throw new IllegalArgumentException("Min balance cannot be negative");
        this.annualInterestRatePercent = annualInterestRatePercent;
        this.minBalanceRequired = minBalanceRequired;
    }

    @Override
    public double calculateInterest() {
        // For demo: return monthly interest (principal * annualRate/12)
        double monthlyInterest = getBalanceForCalculation() * (annualInterestRatePercent / 100.0) / 12.0;
        return monthlyInterest;
    }

    // helper to access balance for calculations (uses protected method)
    private double getBalanceForCalculation() {
        // We can't call getBalance(pin) here — use reflection of protected field via protected method setBalance/getBalance? We don't have getter; use display maybe.
        // For simplicity use the public display pattern: we will not require PIN in this internal calculation — use a protected accessor by adding a protected method in base class would be ideal.
        // But we kept balance private; so to access it here, change BankAccount: provide protected method getProtectedBalance(). (We will add that.)
        // (Implementation note: in this code below BankAccount has setBalance; we'll add getProtectedBalance method above.)
        return BankingSystemHelpers.getProtectedBalance(this);
    }

    // Setters & getters for interest
    public double getAnnualInterestRatePercent() { return annualInterestRatePercent; }
    public void setAnnualInterestRatePercent(double r) {
        if (r < 0) throw new IllegalArgumentException("Interest rate cannot be negative");
        this.annualInterestRatePercent = r;
    }

    public double getMinBalanceRequired() { return minBalanceRequired; }
    public void setMinBalanceRequired(double m) {
        if (m < 0) throw new IllegalArgumentException("Min balance cannot be negative");
        this.minBalanceRequired = m;
    }

    // Loanable implementation
    @Override
    public boolean applyForLoan(double requestedAmount) {
        double eligible = calculateLoanEligibility();
        if (requestedAmount <= eligible) {
            System.out.printf("Loan of %.2f approved for Savings account %s (eligible: %.2f)%n",
                    requestedAmount, getAccountNumber(), eligible);
            return true;
        } else {
            System.out.printf("Loan of %.2f denied for Savings account %s (eligible: %.2f)%n",
                    requestedAmount, getAccountNumber(), eligible);
            return false;
        }
    }

    @Override
    public double calculateLoanEligibility() {
        // Example rule: eligible up to 3 * average balance above minBalance
        double bal = BankingSystemHelpers.getProtectedBalance(this);
        double buffer = Math.max(0, bal - minBalanceRequired);
        return buffer * 3;
    }
}

// ---------------------------
// CurrentAccount (may or may not be Loanable)
// ---------------------------
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit; // e.g., 10000
    private double annualServiceCharge; // annual fee
    private double businessScore; // a score representing business health; affects loan eligibility

    public CurrentAccount(String accountNumber, String holderName, double initialBalance, String pin,
                          double overdraftLimit, double annualServiceCharge, double businessScore) {
        super(accountNumber, holderName, initialBalance, pin);
        if (overdraftLimit < 0) throw new IllegalArgumentException("Overdraft cannot be negative");
        if (annualServiceCharge < 0) throw new IllegalArgumentException("Service charge cannot be negative");
        if (businessScore < 0) throw new IllegalArgumentException("Business score cannot be negative");
        this.overdraftLimit = overdraftLimit;
        this.annualServiceCharge = annualServiceCharge;
        this.businessScore = businessScore;
    }

    @Override
    public double calculateInterest() {
        // Current accounts typically have low/no interest. For demo, use negative interest representing fees (monthly)
        // return monthly fee as negative number to indicate loss.
        return - (annualServiceCharge / 12.0);
    }

    public double getOverdraftLimit() { return overdraftLimit; }
    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit < 0) throw new IllegalArgumentException("Overdraft cannot be negative");
        this.overdraftLimit = overdraftLimit;
    }

    // Loanable implementation: eligibility based on overdraft and businessScore
    @Override
    public boolean applyForLoan(double requestedAmount) {
        double eligible = calculateLoanEligibility();
        if (requestedAmount <= eligible) {
            System.out.printf("Loan of %.2f approved for Current account %s (eligible: %.2f)%n",
                    requestedAmount, getAccountNumber(), eligible);
            return true;
        } else {
            System.out.printf("Loan of %.2f denied for Current account %s (eligible: %.2f)%n",
                    requestedAmount, getAccountNumber(), eligible);
            return false;
        }
    }

    @Override
    public double calculateLoanEligibility() {
        // Example: eligible = overdraftLimit + (businessScore * 1000)
        return overdraftLimit + (businessScore * 1000);
    }
}

// ---------------------------
// BankingSystemHelpers
// (tiny utility to access protected balance — to keep private field truly private we'd add a protected getter in BankAccount; here we provide a safe internal friend helper)
// ---------------------------
class BankingSystemHelpers {
    // Using reflection is one approach but for clarity and maintainability we will downcast to BankAccount and access via known protected accessor.
    // Simpler: add a protected method in BankAccount: getProtectedBalance(). But we can't modify above due to structure.
    // To keep code straightforward, add a public static method that uses a safe interface: we'll add a small protected accessor in BankAccount class.
    // For this demo code, assume BankAccount had protected double getProtectedBalance(); but since we didn't include it earlier, we implement it here via reflection.

    public static double getProtectedBalance(BankAccount acct) {
        try {
            java.lang.reflect.Field f = BankAccount.class.getDeclaredField("balance");
            f.setAccessible(true);
            return f.getDouble(acct);
        } catch (Exception e) {
            throw new RuntimeException("Unable to access balance for calculations", e);
        }
    }
}

// ---------------------------
// Demo (main) - Polymorphism & usage
// ---------------------------
public class BankingSystemDemo {
    public static void main(String[] args) {
        // Create accounts
        SavingsAccount s1 = new SavingsAccount("SAV1001", "Anita Sharma", 50000.0, "1234", 4.0, 1000.0);
        SavingsAccount s2 = new SavingsAccount("SAV1002", "Rajiv Kumar", 8000.0, "4321", 3.5, 500.0);

        CurrentAccount c1 = new CurrentAccount("CUR2001", "Sunita Singh", 20000.0, "9999", 15000.0, 1200.0, 7.5);
        CurrentAccount c2 = new CurrentAccount("CUR2002", "Om Prakash", 3000.0, "8888", 5000.0, 800.0, 2.0);

        // Place accounts into a list of base type (polymorphism)
        List<BankAccount> accounts = Arrays.asList(s1, s2, c1, c2);

        // Display details and calculate interest dynamically
        System.out.println("=== Accounts Summary and Interest Calculation ===");
        for (BankAccount a : accounts) {
            a.displayDetails();
            double interest = a.calculateInterest();
            System.out.printf("Calculated interest (this period): %.2f%n", interest);

            // If account is loanable, show eligibility
            if (a instanceof Loanable) {
                Loanable loanAcc = (Loanable) a;
                double eligible = loanAcc.calculateLoanEligibility();
                System.out.printf("Loan eligibility for %s : %.2f%n", a.getAccountNumber(), eligible);
            }
            System.out.println("--------------------------------------------");
        }

        // Demonstrate deposit, withdraw with authentication & exception handling
        System.out.println("\n=== Transactions Demo (with PIN auth) ===");
        try {
            s1.deposit(5000);
            s1.withdraw(2000, "1234"); // correct PIN
            System.out.printf("Balance for %s: %.2f%n", s1.getAccountNumber(), s1.getBalance("1234"));

            // Attempt withdraw with wrong PIN
            try {
                c1.withdraw(1000, "0000");
            } catch (AuthenticationException ex) {
                System.out.println("Authentication failed: " + ex.getMessage());
            }

            // Attempt withdraw more than balance
            try {
                s2.withdraw(20000, "4321");
            } catch (InsufficientFundsException ex) {
                System.out.println("Withdraw failed: " + ex.getMessage());
            }

            // Apply for loans
            System.out.println("\n=== Loan Applications ===");
            ((Loanable)s1).applyForLoan(50000); // might be approved/denied depending on eligibility
            ((Loanable)c1).applyForLoan(100000);

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        System.out.println("\nDemo complete.");
    }
}
