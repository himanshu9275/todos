interface PrintStrategy {
    void print();
}

class NormalPrint implements PrintStrategy {
    public void print() { System.out.println("Normal printing"); }
}

class ColorPrint implements PrintStrategy {
    public void print() { System.out.println("Color printing"); }
}

class Printer {
    private PrintStrategy strategy;

    public Printer(PrintStrategy strategy) {
        this.strategy = strategy;
    }

    public void print() { strategy.print(); }
}
