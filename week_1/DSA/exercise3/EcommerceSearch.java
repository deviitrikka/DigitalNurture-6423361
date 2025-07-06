import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {

    // Product class
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return productId + " - " + productName + " (" + category + ")";
        }
    }

    // Linear Search
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    // Sort products by productName (required for binary search)
    public static void sortProductsByName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
    }

    // Main method
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Phone", "Electronics"),
            new Product(3, "Shoes", "Fashion"),
            new Product(4, "Watch", "Accessories"),
            new Product(5, "Book", "Education")
        };

        // Linear Search Test
        System.out.println("=== Linear Search ===");
        String searchTarget = "Phone";
        Product resultLinear = linearSearch(products, searchTarget);
        if (resultLinear != null) {
            System.out.println("Found: " + resultLinear);
        } else {
            System.out.println("Product not found.");
        }

        // Binary Search Test
        System.out.println("\n=== Binary Search ===");
        sortProductsByName(products); // Important: must sort before binary search
        Product resultBinary = binarySearch(products, searchTarget);
        if (resultBinary != null) {
            System.out.println("Found: " + resultBinary);
        } else {
            System.out.println("Product not found.");
        }
    }
}
