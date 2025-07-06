package exercise7.ObserverPatternExample;

public class MobileApp implements Observer {
    private final String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("[" + appName + " - Mobile] " +
            stockSymbol + " updated to Rs." + stockPrice);
    }
}