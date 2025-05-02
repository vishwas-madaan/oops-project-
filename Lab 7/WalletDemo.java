package lab7;

import java.util.Scanner;

public class WalletDemo {
	 public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);
	     DigitalWallet myWallet = new DigitalWallet();
	     int choice;

	     do {
	         System.out.println("\n--- Digital Wallet Menu ---");
	         System.out.println("1. Add Funds");
	         System.out.println("2. Spend Funds");
	         System.out.println("3. Check Balance");
	         System.out.println("4. Exit");
	         System.out.print("Enter your choice: ");
	         choice = scanner.nextInt();

	         switch (choice) {
	             case 1:
	                 System.out.print("Enter the amount to add: ₹");
	                 double addAmount = scanner.nextDouble();
	                 myWallet.addFunds(addAmount);
	                 break;
	             case 2:
	                 System.out.print("Enter the amount to spend: ₹");
	                 double spendAmount = scanner.nextDouble();
	                 myWallet.spendFunds(spendAmount);
	                 break;
	             case 3:
	                 System.out.println("Current balance: ₹" + String.format("%.2f", myWallet.getBalance()));
	                 break;
	             case 4:
	                 System.out.println("Exiting Digital Wallet. Goodbye!");
	                 break;
	             default:
	                 System.out.println("Invalid choice. Please try again.");
	         }
	     } while (choice != 4);

	     scanner.close();
	 }
	}