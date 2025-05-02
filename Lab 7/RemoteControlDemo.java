package lab7;

import java.util.Scanner;

public class RemoteControlDemo {
	 public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);
	     Television myTV = new Television();
	     Remote remote = myTV;
	     int choice;

	     do {
	         System.out.println("\n--- Television Remote Control ---");
	         System.out.println("1. Power On");
	         System.out.println("2. Power Off");
	         System.out.println("3. Change Channel");
	         System.out.println("4. Exit");
	         System.out.print("Enter your choice: ");
	         choice = scanner.nextInt();

	         switch (choice) {
	             case 1:
	                 remote.powerOn();
	                 break;
	             case 2:
	                 remote.powerOff();
	                 break;
	             case 3:
	                 System.out.print("Enter the channel number: ");
	                 int channel = scanner.nextInt();
	                 remote.changeChannel(channel);
	                 break;
	             case 4:
	                 System.out.println("Exiting Remote Control. Goodbye!");
	                 break;
	             default:
	                 System.out.println("Invalid choice. Please try again.");
	         }
	     } while (choice != 4);

	     scanner.close();
	 }
	}