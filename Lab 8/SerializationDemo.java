package lab8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	 public static void main(String[] args) {
	     String filename = "person.txt";
	     Person originalPerson = new Person("Alice", 30);

	     // 2. Serialize the Person object to a file
	     try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
	         oos.writeObject(originalPerson);
	         System.out.println("Person object serialized to " + filename);
	     } catch (IOException e) {
	         System.err.println("Error serializing object: " + e.getMessage());
	         return; // Important: Exit if serialization fails
	     }

	     // 3. Deserialize the Person object from the file
	     Person deserializedPerson = null;
	     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
	         deserializedPerson = (Person) ois.readObject();
	         System.out.println("Person object deserialized from " + filename);
	     } catch (IOException | ClassNotFoundException e) {
	         System.err.println("Error deserializing object: " + e.getMessage());
	         return; // Important: Exit if deserialization fails
	     }

	     // 4. Confirm that the deserialized object has the same field values
	     if (deserializedPerson != null) {
	         System.out.println("Original Person: " + originalPerson);
	         System.out.println("Deserialized Person: " + deserializedPerson);

	         if (originalPerson.equals(deserializedPerson)) {
	             System.out.println("Serialization and deserialization successful.  Objects are equal.");
	         } else {
	             System.out.println("Serialization and deserialization failed. Objects are not equal.");
	         }
	     }

}
}