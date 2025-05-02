package lab8;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileProgram {

    // Method to read the file.  It declares that it *might* throw a FileNotFoundException.
    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        // Check if the file exists
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName); // Explicitly throw the exception
        }

        //If the file exists, proceed to read.
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            //It is good practice to throw the exception again if you cannot handle it.
            throw new RuntimeException(e); // Wrap the IOException and rethrow as unchecked
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file to read: ");
        String fileName = scanner.nextLine();
        scanner.close();

        try {
            // Call the readFile method, which might throw a FileNotFoundException
            readFile(fileName);
            System.out.println("File read successfully (if it existed)."); // This will only print if readFile doesn't throw an exception

        } catch (FileNotFoundException e) {
            // Handle the FileNotFoundException here
            System.err.println("Error: " + e.getMessage()); // Print a user-friendly error message
        } finally {
            // This block will always execute, regardless of whether an exception was thrown or not
            System.out.println("File operation attempted.");
        }
        System.out.println("Program continues after try-catch-finally."); //Demonstrates the program continues.
    }
}

