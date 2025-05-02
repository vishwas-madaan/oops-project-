package Lab5;
abstract class Vehicle {
    protected String make;
    protected String model;

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public abstract void startEngine();
    public abstract void stopEngine();

    public void serviceInfo() {
        System.out.println("Service every 6 months or 10,000 km.");
    }
}

class Car extends Vehicle {

    public Car(String make, String model) {
        super(make, model);
    }

    @Override
    public void startEngine() {
        System.out.println(make + " " + model + " engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println(make + " " + model + " engine stopped.");
    }
}

