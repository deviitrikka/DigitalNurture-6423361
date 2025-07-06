package exercise11.DependencyInjectionExample;

public class DITest {
    public static void main(String[] args) {
        // Create the dependency (Repository)
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService service = new CustomerService(repository);

        // Use the service
        System.out.println("=== Customer Lookup ===");
        service.displayCustomerById("C101");
        service.displayCustomerById("C999"); // Not found
    }
}
