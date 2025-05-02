package lab6;


public class BankAccount {
    public void deposit(double amount) {
        System.out.println("Deposited: $" + amount);
    }

    protected void withdraw(double amount) {
        System.out.println("Withdrawn: $" + amount);
    }

    void checkBalance() {
        System.out.println("Balance check: $10,000");
    }

    private void calculateInterest() {
        System.out.println("Interest calculated internally.");
    }
}
