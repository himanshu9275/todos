/**
 * Base class for executing jobs.
 *
 * Subclasses must implement {@link #perform()} to do job-specific work.
 * The {@link #execute()} method is final and ensures pre/post conditions:
 *  - perform() will be invoked in a transaction context.
 *  - Implementations must not close the transaction.
 *  - Implementations must throw only checked exceptions described here.
 */
public abstract class Job {
    public final void execute() { beginTx(); try { perform(); commitTx(); } catch(...) { rollback(); } }
    protected abstract void perform() throws JobException;
}
