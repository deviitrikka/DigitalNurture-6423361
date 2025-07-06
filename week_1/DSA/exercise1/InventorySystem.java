import java.util.HashMap;
import java.util.Map;

public class InventorySystem {

    // Product class
    static class Product {
        private int productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public int getProductId() { return productId; }
        public String getProductName() { return productName; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "ID: " + productId + ", Name: " + productName +
                   ", Quantity: " + quantity + ", Price: Rs. " + price;
        }
    }

    // Inventory manager class
    static class InventoryManager {
        private Map<Integer, Product> inventory;

        public InventoryManager() {
            inventory = new HashMap<>();
        }

        public void addProduct(Product product) {
            if (inventory.containsKey(product.getProductId())) {
                System.out.println("Product already exists. Use updateProduct to modify it.");
            } else {
                inventory.put(product.getProductId(), product);
                System.out.println("Product added: " + product.getProductName());
            }
        }

        public void updateProduct(int productId, String name, Integer quantity, Double price) {
            if (inventory.containsKey(productId)) {
                Product product = inventory.get(productId);
                if (name != null) product.setProductName(name);
                if (quantity != null) product.setQuantity(quantity);
                if (price != null) product.setPrice(price);
                System.out.println("Product updated: " + productId);
            } else {
                System.out.println("Product not found.");
            }
        }

        public void deleteProduct(int productId) {
            if (inventory.containsKey(productId)) {
                inventory.remove(productId);
                System.out.println("Product deleted: " + productId);
            } else {
                System.out.println("Product not found.");
            }
        }

        public void displayInventory() {
            if (inventory.isEmpty()) {
                System.out.println("Inventory is empty.");
            } else {
                for (Product product : inventory.values()) {
                    System.out.println(product);
                }
            }
        }
    }

    // Main method to test the system
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Adding products
        Product p1 = new Product(101, "Keyboard", 10, 229.99);
        Product p2 = new Product(102, "Mouse", 25, 219.99);
        Product p3 = new Product(103, "Monitor", 5, 1149.99);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);

        System.out.println("\nCurrent Inventory:");
        manager.displayInventory();

        // Updating a product
        manager.updateProduct(102, "Wireless Mouse", 20, 24.99);

        // Deleting a product
        manager.deleteProduct(103);

        System.out.println("\nUpdated Inventory:");
        manager.displayInventory();
    }
}
