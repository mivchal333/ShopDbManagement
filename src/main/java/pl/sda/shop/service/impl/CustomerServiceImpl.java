package pl.sda.shop.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.shop.domain.Customer;
import pl.sda.shop.service.CustomerService;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null) {
            if (customer.getId() == null) {
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);
        } else {
            throw new RuntimeException("Customer can't be null");
        }
        return getCustomerById(customer.getId());
    }

    private Integer getNextKey() {
        return Collections.max(customers.keySet()) + 1;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

    public CustomerServiceImpl() {
        customers = new HashMap<>();
        loadCustomers();
    }

    private void loadCustomers() {
        for (int i = 0; i < 5; i++) {
            Customer c = new Customer();
            c.setId(i);
            c.setFirstName("Adam");
            c.setLastName("Nowacki");
            c.setAddressLineOne("Domieszkowa");
            c.setAdressLineTwo("12/1");
            c.setCity("Krakow");
            c.setEmail("adam@nowacki.pl");
            c.setPhoneNumber("123123123");
            c.setState("Main");
            c.setZipCode("12-315");
            customers.put(i, c);
        }
    }
}
