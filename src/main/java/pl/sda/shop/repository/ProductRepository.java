package pl.sda.shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.shop.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
