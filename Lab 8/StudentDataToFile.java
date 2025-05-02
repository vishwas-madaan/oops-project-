package lab8;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentDataToFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student roll number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        scanner.close();

        // The file name to write to
        String fileName = "student.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            // Use PrintWriter for convenient writing, and FileWriter with append=true
            // to append to the file.  try-with-resources ensures the writer is closed.

            // Format the student data as a comma-separated string, as in the sample.
            String studentData = "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;

            // Write the student data to the file, followed by a newline character.
            writer.println(studentData);
            System.out.println("Student information appended to " + fileName);

        } catch (IOException e) {
            // Handle any IOException that might occur during file writing.
            System.err.println("Error writing to file " + fileName + ": " + e.getMessage());
        }
        
    }
}

