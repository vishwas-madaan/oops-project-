package lab6;
public final class SecuritySystem {
    public void authenticateUser(String username, String password) {
        if ("admin".equals(username) && "1234".equals(password)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}
