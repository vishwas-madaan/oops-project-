package lab8;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WordCharacterCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the text file: ");
        String fileName = scanner.nextLine();
        scanner.close();

        int wordCount = 0;
        int characterCount = 0;

        // Use try-with-resources to automatically close the reader
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split the line into words using whitespace as the delimiter
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) { //check if the word is empty
                        wordCount++;
                    }
                }
                // Remove leading and trailing whitespace, and count characters
                characterCount += line.trim().length();
            }
            System.out.println("File: " + fileName);
            System.out.println("Word count: " + wordCount);
            System.out.println("Character count (excluding whitespace): " + characterCount);

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + fileName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}