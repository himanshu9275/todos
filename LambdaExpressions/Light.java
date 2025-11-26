import java.util.*;
import java.util.function.Consumer;

class Light {
    String id;
    boolean on;
    int brightness; // 0-100
    String color;

    Light(String id) { this.id = id; this.on = false; this.brightness = 100; this.color = "white"; }

    void on() { on = true; System.out.println(id + ": ON"); }
    void off() { on = false; System.out.println(id + ": OFF"); }
    void setBrightness(int b) { brightness = b; System.out.println(id + ": Brightness=" + b); }
    void setColor(String c) { color = c; System.out.println(id + ": Color=" + c); }

    @Override public String toString() { return id + " [on=" + on + ",b=" + brightness + ",color=" + color + "]"; }
}

class AutomationEngine {
    // store named behaviors
    private Map<String, Consumer<Light>> behaviors = new HashMap<>();

    void register(String trigger, Consumer<Light> action) { behaviors.put(trigger, action); }

    void trigger(String trigger, Light light) {
        Consumer<Light> action = behaviors.get(trigger);
        if (action != null) action.accept(light);
        else System.out.println("No behavior for: " + trigger);
    }

    public static void main(String[] args) {
        Light hallway = new Light("Hallway");
        AutomationEngine engine = new AutomationEngine();

        // Motion trigger: turn on dim warm light
        engine.register("motion", l -> { l.on(); l.setBrightness(50); l.setColor("warm white"); });

        // Time-of-day (evening) trigger: cozy mode
        engine.register("evening", l -> { l.on(); l.setBrightness(30); l.setColor("amber"); });

        // Voice command lambda (e.g., 'party')
        engine.register("party", l -> { l.on(); l.setBrightness(100); l.setColor("blue"); });

        // Simulate triggers
        engine.trigger("motion", hallway);
        engine.trigger("evening", hallway);
        engine.trigger("party", hallway);

        System.out.println("Final state: " + hallway);
    }
}
