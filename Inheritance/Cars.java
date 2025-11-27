// GOOD: Car HAS an Engine
class Engine {
    public void start() { System.out.println("Engine started"); }
}

class Car {
    private final Engine engine;        // composition (has-a)

    public Car(Engine engine) { this.engine = engine; }

    public void drive() {
        engine.start();
        System.out.println("Car driving");
    }
}

public class GoodExample {
    public static void main(String[] args) {
        Engine e = new Engine();
        Car c = new Car(e);
        c.drive();
    }
}
