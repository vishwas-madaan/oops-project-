package lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeArrayListUserInput {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

      
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("ID: ");
            int id = scanner.nextInt();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over

            employees.add(new Employee(name, id, salary));
        }

      
        System.out.print("Enter the ID of the employee whose salary you want to update: ");
        int updateId = scanner.nextInt();
        System.out.print("Enter the new salary: ");
        double newSalary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        for (Employee emp : employees) {
            if (emp.id == updateId) {
                emp.salary = newSalary;
                break;
            }
        }

       
        System.out.print("Enter the ID of the employee you want to remove: ");
        int removeId = scanner.nextInt();

        employees.removeIf(emp -> emp.id == removeId);

       
        System.out.println("\nRemaining Employees:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        scanner.close();
    }
}