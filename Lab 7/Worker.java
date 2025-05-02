package lab7;
import java.util.Scanner;


abstract class Worker {
 private String name;
 private int workerId;

 public Worker(String name, int workerId) {
     this.name = name;
     this.workerId = workerId;
 }

 
 public abstract double computePay();


 public abstract void displayInfo();


 public String getName() {
     return name;
 }

 public int getWorkerId() {
     return workerId;
 }
}


class FullTimeWorker extends Worker {
 private double monthlySalary;

 public FullTimeWorker(String name, int workerId, double monthlySalary) {
     super(name, workerId);
     this.monthlySalary = monthlySalary;
 }


 @Override
 public double computePay() {
     return monthlySalary;
 }

 
 @Override
 public void displayInfo() {
     System.out.println("--- Full-Time Worker ---");
     System.out.println("Name: " + getName());
     System.out.println("Worker ID: " + getWorkerId());
     System.out.println("Monthly Salary: ₹" + String.format("%.2f", computePay()));
 }
}


class PartTimeWorker extends Worker {
 private double hourlyRate;
 private int hoursWorked;

 public PartTimeWorker(String name, int workerId, double hourlyRate, int hoursWorked) {
     super(name, workerId);
     this.hourlyRate = hourlyRate;
     this.hoursWorked = hoursWorked;
 }

 // Implement computePay() for part-time workers
 @Override
 public double computePay() {
     return hourlyRate * hoursWorked;
 }

 // Implement displayInfo() for part-time workers
 @Override
 public void displayInfo() {
     System.out.println("--- Part-Time Worker ---");
     System.out.println("Name: " + getName());
     System.out.println("Worker ID: " + getWorkerId());
     System.out.println("Hourly Rate: ₹" + String.format("%.2f", hourlyRate));
     System.out.println("Hours Worked: " + hoursWorked);
     System.out.println("Total Pay: ₹" + String.format("%.2f", computePay()));
 }
}

