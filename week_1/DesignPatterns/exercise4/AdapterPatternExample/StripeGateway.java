package exercise4.AdapterPatternExample;

public class StripeGateway {
    public void makePayment(double value) {
        System.out.println("Charged Rs." + value + " using Stripe.");
    }
}
