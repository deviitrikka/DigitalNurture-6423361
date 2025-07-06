public class OrderSort {

    // Order class definition
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return orderId + " - " + customerName + " - Rs." + totalPrice;
        }
    }

    // Bubble Sort by totalPrice
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: stop if already sorted
        }
    }

    // Quick Sort by totalPrice
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    // Partition function for quick sort
    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap pivot into correct position
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Display all orders
    public static void printOrders(String title, Order[] orders) {
        System.out.println(title);
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }

    // Main method to test both sorting algorithms
    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(101, "Alice", 250.75),
            new Order(102, "Bob", 120.50),
            new Order(103, "Charlie", 560.20),
            new Order(104, "David", 300.00),
            new Order(105, "Eve", 150.00)
        };

        // Duplicate array for quick sort
        Order[] orders2 = new Order[orders1.length];
        System.arraycopy(orders1, 0, orders2, 0, orders1.length);

        // Bubble Sort
        bubbleSort(orders1);
        printOrders("Orders sorted by Bubble Sort (by totalPrice):", orders1);

        // Quick Sort
        quickSort(orders2, 0, orders2.length - 1);
        printOrders("Orders sorted by Quick Sort (by totalPrice):", orders2);
    }
}
