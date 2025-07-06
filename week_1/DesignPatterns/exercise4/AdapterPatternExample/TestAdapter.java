package exercise4.AdapterPatternExample;

public class TestAdapter {
    public static void main(String[] args) {
        // Using PayPal through the adapter
        PaymentProcessor paypalProcessor = new PaypalAdapter(new PaypalGateway());
        paypalProcessor.processPayment(120.50);

        // Using Stripe through the adapter
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(75.25);
    }
}
