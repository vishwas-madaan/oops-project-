package lab9;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductInventory {

    public static void main(String[] args) {
        HashMap<Integer, Integer> inventory = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

   
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");
            System.out.print("Product ID: ");
            int productId = scanner.nextInt();
            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            inventory.put(productId, quantity);
        }

  
        System.out.print("Enter the ID of the product whose quantity you want to update: ");
        int updateId = scanner.nextInt();
        System.out.print("Enter the new quantity: ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        inventory.put(updateId, newQuantity);

  
        System.out.print("Enter the ID of the product you want to remove: ");
        int removeId = scanner.nextInt();

        inventory.remove(removeId);

    
        System.out.println("\nFinal Inventory:");
        for (Map.Entry<Integer, Integer> entry : inventory.entrySet()) {
            System.out.println("Product ID: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }

        scanner.close();
    }
}