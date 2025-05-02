package vishu;
public class Customer {
    private double balance;

    public Customer() {
        this.balance = 0.0;
    }

    public void addBalance(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    public void addBalance(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    protected void deductBalance(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Deducted: " + amount);
        } else {
            System.out.println("Invalid deduction amount.");
        }
    }

    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.addBalance(500.50);
        customer.addBalance(100);
        customer.showBalance();
        customer.deductBalance(200.0);
        customer.showBalance();
    }
}