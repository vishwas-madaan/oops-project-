package Lab5;
class SuperClass {
    private int secret = 42;

    public void showSecret() {
        System.out.println("Secret is: " + secret);
    }
}

class SubClass extends SuperClass {
    public void tryAccess() {
        // System.out.println(secret); // ❌ Compile-time error: secret has private access
        System.out.println("Cannot access private member directly!");
    }
}

