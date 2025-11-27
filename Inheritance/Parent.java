class Parent {
    void process() {}
}

class Child extends Parent {
    @Override
    void process() {} // compiler will error if method signature is incorrect
}
