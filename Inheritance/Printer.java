class Printer {
    public void print() { System.out.println("Normal printing"); }
}

class ColorPrinter extends Printer {
    @Override
    public void print() {
        System.out.println("Color printing");
    }
}
