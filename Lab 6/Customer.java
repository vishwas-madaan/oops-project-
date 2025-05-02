package lab6;
public class Customer extends BankAccount {
    public static void main(String[] args) {
        Customer cust = new Customer();

        cust.deposit(500);            // Accessible (public)
        cust.withdraw(200);           // Accessible (protected via inheritance)

        // cust.checkBalance();       // ❌ Not accessible (default access – same package only)
        // cust.calculateInterest();  // ❌ Not accessible (private method)
    }
}