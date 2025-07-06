package exercise8.StrategyPatternExample;

public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;
    private final String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card [" + cardNumber + "] - Holder: " + cardHolderName);
    }
}
