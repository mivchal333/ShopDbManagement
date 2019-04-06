package pl.sda.shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.shop.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
