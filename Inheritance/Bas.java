public class Base {
    public Base() { init(); }             // calling overridable method
    protected void init() { /*...*/ }
}
public class Derived extends Base {
    private final String name = compute(); // not yet initialized when Base() calls init()
    @Override protected void init() { System.out.println(name.length()); } // NPE
}
