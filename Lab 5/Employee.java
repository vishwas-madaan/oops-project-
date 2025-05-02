package Lab5;
class Employee {
    private String name;
    private int empid;
    private double salary;

    public Employee() {
        this.name = "Unknown";
        this.empid = 0;
        this.salary = 0.0;
    }

    public Employee(String name, int empid, double salary) {
        this.name = name;
        this.empid = empid;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double percentage) {
        salary += salary * (percentage / 100);
    }

    public void display() {
        System.out.println("Name: " + name + ", ID: " + empid + ", Salary: " + salary);
    }
}

class Manager extends Employee {
    private String department;

    public Manager(String name, int empid, double salary, String department) {
        super(name, empid, salary);
        this.department = department;
    }

    public void display() {
        super.display();
        System.out.println("Department: " + department);
    }
}

