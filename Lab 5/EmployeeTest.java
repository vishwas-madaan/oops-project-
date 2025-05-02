package Lab5;
public class EmployeeTest {
    public static void main(String[] args) {
        Manager mgr = new Manager("John Doe", 101, 60000, "HR");
        mgr.display();
        mgr.increaseSalary(10);
        System.out.println("After salary increase:");
        mgr.display();
    }
}
