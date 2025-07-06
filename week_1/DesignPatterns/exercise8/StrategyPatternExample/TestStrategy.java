package exercise8.StrategyPatternExample;

public class TestStrategy {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card
        PaymentStrategy creditCard = new CreditCardPayment("1234-4242-9012-4242", "ABC XYZ");
        context.setPaymentStrategy(creditCard);
        context.makePayment(250.00);

        // Use PayPal
        PaymentStrategy paypal = new PayPalPayment("xyz@example.com");
        context.setPaymentStrategy(paypal);
        context.makePayment(89.99);
    }
}