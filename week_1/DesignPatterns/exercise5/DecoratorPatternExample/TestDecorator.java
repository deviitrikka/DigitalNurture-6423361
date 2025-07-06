package exercise5.DecoratorPatternExample;

public class TestDecorator {
    public static void main(String[] args) {
        // Start with basic Email notification
        Notifier notifier = new EmailNotifier();

        // Add SMS notification
        notifier = new SMSNotifierDecorator(notifier);

        // Add Slack notification
        notifier = new SlackNotifierDecorator(notifier);

        // Send message through all channels
        notifier.send("System will undergo maintenance at 11 PM.");
    }
}