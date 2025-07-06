package exercise11.DependencyInjectionExample;

public interface CustomerRepository {
    Customer findCustomerById(String id);
}
