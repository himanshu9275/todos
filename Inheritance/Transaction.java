public abstract class Transaction {
    public final void execute() {   // critical algorithm skeleton
        begin();
        try {
            doWork();   // hook method overridden by subclasses
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }
    protected abstract void doWork();
    private void begin(){ /*...*/ }
    private void commit(){ /*...*/ }
    private void rollback(){ /*...*/ }
}
