package vishu;
public class Product {
    private static int totalProducts = 0;
    private int productId;
    private String productName;
    private String category;
    private double price;

    public Product() {
        this.productId = 0;
        this.productName = "Default Product";
        this.category = "General";
        this.price = 0.0;
        totalProducts++;
    }

    public Product(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        totalProducts++;
    }

    public double getPrice() {
        return price;
    }

    public void displayProductInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Price: $" + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public double calculateStockValue(int quantity) {
        return price * quantity;
    }

    public double calculateStockValue(int quantity, double discountRate) {
        double discountedPrice = price * (1 - discountRate / 100);
        return discountedPrice * quantity;
    }

    public static void main(String[] args) {
        Product product1 = new Product();
        Product product2 = new Product(101, "Laptop", "Electronics", 850.50);
        Product product3 = new Product(102, "Smartphone", "Electronics", 499.99);

        Product.displayTotalProducts();

        product1.displayProductInfo();
        System.out.println("Stock Value (10 units): $" + product1.calculateStockValue(10));
        System.out.println("------------------------------");

        product2.displayProductInfo();
        System.out.println("Stock Value (5 units): $" + product2.calculateStockValue(5));
        System.out.println("Stock Value (5 units, 10% discount): $" + product2.calculateStockValue(5, 10));
        System.out.println("------------------------------");

        product3.displayProductInfo();
        System.out.println("Stock Value (3 units): $" + product3.calculateStockValue(3));
        System.out.println("Stock Value (3 units, 5% discount): $" + product3.calculateStockValue(3, 5));
        System.out.println("------------------------------");
    }
}


