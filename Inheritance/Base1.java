class Base {
    public void calculate() {
        System.out.println("Base calculation");
    }
}

class Child extends Base {
    @Override
    public void calculate() {
        System.out.println("Child calculation");
        super.calculate();
    }
}
