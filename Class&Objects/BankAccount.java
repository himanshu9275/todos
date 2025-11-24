class BankAccount {
    String accountHolder;
    long accountNumber;
    double balance;

    // Deposit Method
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance! Withdrawal failed.");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        }
    }

    // Display Current Balance
    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class ATMTest {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.accountHolder = "Rohan Singh";
        acc.accountNumber = 9876543210L;
        acc.balance = 5000;

        acc.displayBalance();
        acc.deposit(2000);
        acc.withdraw(1500);
        acc.displayBalance();
    }
}
