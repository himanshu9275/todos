class Vehicle {
    public void move() { System.out.println("Moving..."); }
}

class Car extends Vehicle {            // Car **is a** Vehicle
    @Override
    public void move() { 
        System.out.println("Car driving on road");
    }
}
