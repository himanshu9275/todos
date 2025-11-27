public interface Flyable { void fly(); }
public interface Chargeable { void charge(); }
public class Drone implements Flyable, Chargeable {
    @Override public void fly() { /*...*/ }
    @Override public void charge() { /*...*/ }
}
