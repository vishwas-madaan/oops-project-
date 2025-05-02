package Lab5;
public class UniversityTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Professor("Dr. Smith", 45, "123 Uni St", "S1001", "Physics", "Quantum Mechanics");
        people[1] = new GraduateStudent("Alice", 25, "456 Dorm Ln", "G2001", "Computer Science", "AI in Healthcare");

        for (Person p : people) {
            p.display();
            if (p instanceof Professor) {
                ((Professor) p).conductLecture();
            } else if (p instanceof GraduateStudent) {
                ((GraduateStudent) p).submitThesis();
            }
            System.out.println();
        }
    }
}
