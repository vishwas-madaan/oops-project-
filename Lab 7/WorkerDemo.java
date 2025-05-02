package lab7;

import java.util.Scanner;

public class WorkerDemo {
	 public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);

	     // Input for Full-Time Worker
	     System.out.println("--- Enter details for Full-Time Worker ---");
	     System.out.print("Name: ");
	     String fullTimeName = scanner.nextLine();
	     System.out.print("Worker ID: ");
	     int fullTimeId = scanner.nextInt();
	     System.out.print("Monthly Salary: ");
	     double fullTimeSalary = scanner.nextDouble();
	     scanner.nextLine(); // Consume the newline character

	     FullTimeWorker fullTimeWorker = new FullTimeWorker(fullTimeName, fullTimeId, fullTimeSalary);

	     System.out.println("\n--- Enter details for Part-Time Worker ---");
	     System.out.print("Name: ");
	     String partTimeName = scanner.nextLine();
	     System.out.print("Worker ID: ");
	     int partTimeId = scanner.nextInt();
	     System.out.print("Hourly Rate: ");
	     double partTimeRate = scanner.nextDouble();
	     System.out.print("Hours Worked: ");
	     int partTimeHours = scanner.nextInt();
	     scanner.nextLine(); // Consume the newline character

	     PartTimeWorker partTimeWorker = new PartTimeWorker(partTimeName, partTimeId, partTimeRate, partTimeHours);

	     // Demonstrate polymorphism
	     System.out.println("\n--- Worker Information ---");
	     fullTimeWorker.displayInfo();
	     System.out.println();
	     partTimeWorker.displayInfo();
	     System.out.println();

	     System.out.println("--- Calculating Pay ---");
	     System.out.println(fullTimeWorker.getName() + "'s Pay: ₹" + String.format("%.2f", fullTimeWorker.computePay()));
	     System.out.println(partTimeWorker.getName() + "'s Pay: ₹" + String.format("%.2f", partTimeWorker.computePay()));

	     scanner.close();
	 }
	}