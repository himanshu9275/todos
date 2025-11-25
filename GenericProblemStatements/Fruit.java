class Fruit {
    String name;

    Fruit(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Apple extends Fruit {
    Apple() {
        super("Apple");
    }
}

class Mango extends Fruit {
    Mango() {
        super("Mango");
    }
}
