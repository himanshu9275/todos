// shared behavior + required hook
public abstract class PaymentProcessor {
    public final void processPayment(double amt) {   // template method
        validate(amt);
        double fee = calculateFee(amt);              // subclass responsibility
        doTransfer(amt - fee);
        log(amt, fee);
    }
    protected abstract double calculateFee(double amt);
    protected abstract void doTransfer(double netAmount);

    private void validate(double amt) {
        if (amt <= 0) throw new IllegalArgumentException("amount");
    }
    private void log(double amt, double fee) { /* audit */ }
}
