package exercise11.DependencyInjectionExample;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<String, Customer> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Dummy data
        customers.put("C101", new Customer("C101", "Jake Ross"));
        customers.put("C102", new Customer("C102", "Jane Smith"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return customers.get(id);
    }
}
