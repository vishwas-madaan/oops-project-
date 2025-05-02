package lab9;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class hash {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of names: ");
        int numNames = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] names = new String[numNames];
        for (int i = 0; i < numNames; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            uniqueNames.add(name);
        }

        System.out.print("Enter a name to check if it exists: ");
        String checkName = scanner.nextLine();

        if (uniqueNames.contains(checkName)) {
            System.out.println(checkName + " exists in the set.");
        } else {
            System.out.println(checkName + " does not exist in the set.");
        }

        System.out.println("\nUnique Names:");
        for (String uniqueName : uniqueNames) {
            System.out.println(uniqueName);
        }

        scanner.close();
    }
}