package lab6;
public class AdvancedSecurity extends SecuritySystem {
    @Override
    public void authenticateUser(String username, String password) {
        System.out.println("Custom authentication logic."); // ❌ Cannot override
    }
}
