// SmartDevice.java
public interface SmartDevice {
    void turnOn();
    void turnOff();
}

// Light.java
class Light implements SmartDevice {
    @Override public void turnOn() { System.out.println("Light ON"); }
    @Override public void turnOff() { System.out.println("Light OFF"); }
}

// AC.java
class AC implements SmartDevice {
    @Override public void turnOn() { System.out.println("AC cooling ON"); }
    @Override public void turnOff() { System.out.println("AC OFF"); }
}

// Demo
public class SmartDeviceDemo {
    public static void main(String[] args) {
        SmartDevice l = new Light();
        SmartDevice ac = new AC();
        l.turnOn(); ac.turnOn();
        l.turnOff(); ac.turnOff();
    }
}
