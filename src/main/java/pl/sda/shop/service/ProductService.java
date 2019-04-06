package pl.sda.shop.service;

import pl.sda.shop.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> listAllProducts();

    Optional<Product> getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);
}
