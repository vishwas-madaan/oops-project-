package lab8;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadStudentFile {

    public static void main(String[] args) {
        String fileName = "student.txt"; // The name of the file to read

        try {
            // Attempt to open and read the file using FileReader and BufferedReader
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Print each line to the console
            }

            // Close the BufferedReader to release resources
            bufferedReader.close();
            fileReader.close(); //added to close the fileReader

        } catch (FileNotFoundException e) {
            // Handle the case where the file does not exist
            System.err.println("Error: The file '" + fileName + "' was not found.");
        } catch (IOException e) {
            // Handle other potential IOExceptions (e.g., problems reading the file)
            System.err.println("Error reading the file '" + fileName + "': " + e.getMessage());
        }
       
    }
}

