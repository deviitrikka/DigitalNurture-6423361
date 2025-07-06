package exercise4.AdapterPatternExample;

public class PaypalGateway {
    public void sendPayment(double amountInDollars) {
        System.out.println("Paid Rs." + amountInDollars + " using PayPal.");
    }
}
