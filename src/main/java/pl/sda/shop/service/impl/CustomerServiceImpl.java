package pl.sda.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.shop.domain.Customer;
import pl.sda.shop.repository.CustomerRepository;
import pl.sda.shop.service.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> listAllCustomers() {
        LinkedList<Customer> customers = new LinkedList<>();
        Iterable<Customer> customersIt = repository.findAll();
        customersIt.forEach(customers::add);
        return customers;
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null) {
            return repository.save(customer);
        } else {
            throw new RuntimeException("Customer can't be null");
        }
    }


    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

}
