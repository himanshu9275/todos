// Parent class
class BankAccount {
    public String accountNumber;       // public
    protected String holderName;       // protected
    private double balance;            // private

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Public method to deposit
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    // Public method to withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance!");
    }

    // Public getter (encapsulation)
    public double getBalance() {
        return balance;
    }

    public void showAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: ₹" + balance);
    }
}

// Subclass using protected member
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public void showSavingsAccount() {
        // Access protected member: allowed
        System.out.println("Savings Account Holder (protected): " + holderName);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Test class
public class BankDemo {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("ACC123", "Amit Verma", 25000, 6.5);

        sa.showAccountDetails();
        sa.showSavingsAccount();

        sa.deposit(5000);
        sa.withdraw(8000);

        System.out.println("Updated Balance: ₹" + sa.getBalance());
    }
}
