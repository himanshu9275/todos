// BAD: Car is NOT an Engine
class Engine {
    public void start() { System.out.println("Engine started"); }
}

class Car extends Engine {              // ❌ wrong design: Car is not-a Engine
    public void drive() { 
        start(); // works but conceptually wrong
        System.out.println("Car driving");
    }
}

public class BadExample {
    public static void main(String[] args) {
        Car c = new Car();
        c.drive();
    }
}
