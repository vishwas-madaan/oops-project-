package lab8;
import java.io.*;

//1. Define the Person class and implement Serializable
class Person implements Serializable {
 private static final long serialVersionUID = 1L; // Recommended: Explicitly set serialVersionUID
 String name;
 int age;

 public Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 // Override toString() for easy printing of Person objects
 @Override
 public String toString() {
     return "Person{name='" + name + "', age=" + age + '}';
 }

  //Added equals and hashcode methods.
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true;
     if (obj == null || getClass() != obj.getClass()) return false;
     Person other = (Person) obj;
     return age == other.age && (name == null ? other.name == null : name.equals(other.name));
 }

 @Override
 public int hashCode() {
     int result = name != null ? name.hashCode() : 0;
     result = 31 * result + age;
     return result;
 }
}
