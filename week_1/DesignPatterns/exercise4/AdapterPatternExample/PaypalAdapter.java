package exercise4.AdapterPatternExample;

public class PaypalAdapter implements PaymentProcessor {
    private final PaypalGateway paypal;

    public PaypalAdapter(PaypalGateway paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.sendPayment(amount);
    }
}
