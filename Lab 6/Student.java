package lab6;
public class Student {
    private String studentId;
    private String name;
    private char grade;

    public Student(String studentId, String name, char grade) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
    }

    public void displayStudentInfo() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}