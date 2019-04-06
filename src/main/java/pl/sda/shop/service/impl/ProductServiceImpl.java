package pl.sda.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.shop.domain.Product;
import pl.sda.shop.repository.ProductRepository;
import pl.sda.shop.service.ProductService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> listAllProducts() {
        List<Product> products = new LinkedList<>();
        Iterable<Product> iterable = repository.findAll();
        iterable.forEach(products::add);
        return products;
    }

    @Override
    public Optional<Product> getProductById(Integer id) {

        return repository.findById(id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        if (product != null) {
            return repository.save(product);
        } else {
            throw new RuntimeException("Product can't be null");
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.deleteById(id);
    }
}
