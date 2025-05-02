package lab6;
public class MainSecurity {
    public static void main(String[] args) {
        SecuritySystem sec = new SecuritySystem();
        sec.authenticateUser("admin", "1234");
    }
}
