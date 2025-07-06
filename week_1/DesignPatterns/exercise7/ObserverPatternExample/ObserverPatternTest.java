// ObserverPatternTest.java
package exercise7.ObserverPatternExample;

public class ObserverPatternTest {
    public static void main(String[] args) {
        // Create StockMarket (Subject)
        StockMarket stockMarket = new StockMarket();

        // Create Observers
        MobileApp mobileApp = new MobileApp("MyStocks");
        WebApp webApp = new WebApp("StockTracker");

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Update stock data - both observers should be notified
        System.out.println("=== First Update ===");
        stockMarket.setStockData("AAPL", 1185.67);

        // Remove mobile app observer
        stockMarket.removeObserver(mobileApp);

        // Update stock data - only web app should be notified
        System.out.println("=== Second Update ===");
        stockMarket.setStockData("GOOGL", 9735.45);
    }
}