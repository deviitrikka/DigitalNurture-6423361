package exercise7.ObserverPatternExample;

public class WebApp implements Observer {
    private final String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("[" + appName + " - Web] " +
            stockSymbol + " is now Rs." + stockPrice);
    }
}
