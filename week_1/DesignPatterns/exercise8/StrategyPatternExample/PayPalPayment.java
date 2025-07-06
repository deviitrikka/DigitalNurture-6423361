package exercise8.StrategyPatternExample;

public class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using PayPal account: " + email);
    }
}
