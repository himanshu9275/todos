interface Shape { int area(); }

class Rectangle implements Shape {
    private final int width, height;
    public Rectangle(int w,int h){ width=w; height=h; }
    public int area(){ return width*height; }
}

class Square implements Shape {
    private final int side;
    public Square(int s){ side = s; }
    public int area(){ return side * side; }
}
