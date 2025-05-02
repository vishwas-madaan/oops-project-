package Lab5;
public class VehicleTest {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Corolla");
        myCar.startEngine();
        myCar.serviceInfo();
        myCar.stopEngine();
    }
}
