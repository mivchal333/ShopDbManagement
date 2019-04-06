package pl.sda.shop.service;

import pl.sda.shop.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> listAllCustomers();

    Optional<Customer> getCustomerById(Integer id);

    Customer saveOrUpdateCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
