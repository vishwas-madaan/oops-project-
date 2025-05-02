package lab7;
import java.util.Scanner;


interface Wallet {
 void addFunds(double amount);
 boolean spendFunds(double amount); 
}


class DigitalWallet implements Wallet {
 private double balance;

 public DigitalWallet() {
     this.balance = 0.0;
 }

 @Override
 public void addFunds(double amount) {
     if (amount > 0) {
         this.balance += amount;
         System.out.println("₹" + String.format("%.2f", amount) + " added to the wallet. Current balance: ₹" + String.format("%.2f", this.balance));
     } else {
         System.out.println("Invalid amount. Please enter a positive value to add funds.");
     }
 }

 @Override
 public boolean spendFunds(double amount) {
     if (amount > 0 && this.balance >= amount) {
         this.balance -= amount;
         System.out.println("₹" + String.format("%.2f", amount) + " spent from the wallet. Current balance: ₹" + String.format("%.2f", this.balance));
         return true;
     } else if (amount <= 0) {
         System.out.println("Invalid amount. Please enter a positive value to spend.");
         return false;
     } else {
         System.out.println("Insufficient funds. Current balance: ₹" + String.format("%.2f", this.balance));
         return false;
     }
 }

 public double getBalance() {
     return this.balance;
 }
}


