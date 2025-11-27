class Rectangle {
    int width, height;
    public void setWidth(int w) { width = w; }
    public void setHeight(int h) { height = h; }
    public int area() { return width * height; }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int w) { width = w; height = w; }   // changes behavior
    @Override
    public void setHeight(int h) { height = h; width = h; }  // breaks expectation
}

// Client code expecting Rectangle behavior:
void resize(Rectangle r) {
    r.setWidth(5);
    r.setHeight(4);
    // expects area == 20, but with Square may be 25
}
