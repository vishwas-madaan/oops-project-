package vishu;

import java.util.Scanner;

public class Car {
    String make, model;
    int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayDetails() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter car make: ");
        String make = scanner.nextLine();
        System.out.println("Enter car model: ");
        String model = scanner.nextLine();
        System.out.println("Enter car year: ");
        int carYear = scanner.nextInt();
        Car car = new Car(make, model, carYear);
        car.displayDetails();
    }
}

