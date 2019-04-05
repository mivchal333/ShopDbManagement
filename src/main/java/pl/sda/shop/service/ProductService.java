package pl.sda.shop.service;

import pl.sda.shop.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);
}
