package lab9;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class unique {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int numIntegers = scanner.nextInt();
        scanner.nextLine(); 

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numIntegers; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        int sum = 0;
        for (int num : uniqueNumbers) {
            sum += num;
        }

        System.out.println("Sum of unique values: " + sum);

        System.out.println("Unique integers: " + uniqueNumbers);

        scanner.close();
    }
}