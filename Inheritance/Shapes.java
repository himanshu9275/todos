abstract class Shape {
    public double area() { return computeArea(); }

    protected abstract double computeArea();
}

class Circle extends Shape {
    private double r;

    public Circle(double r) { this.r = r; }

    @Override
    protected double computeArea() { return Math.PI * r * r; }
}
