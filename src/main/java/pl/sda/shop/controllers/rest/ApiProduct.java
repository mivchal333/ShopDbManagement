package pl.sda.shop.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.shop.domain.Product;
import pl.sda.shop.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ApiProduct {

    @Autowired
    ProductService service;

    @RequestMapping(value = "/")
    public List<Product> getAllProducts() {
        return service.listAllProducts();
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Integer id) {
        Optional<Product> productOpt = service.getProductById(id);
        if (productOpt.isPresent()) {
            return new ResponseEntity<>(productOpt.get(), HttpStatus.OK);
        } else return new ResponseEntity<>("404 NotFound", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addProduct(@RequestBody Product product) {
        service.saveOrUpdateProduct(product);
    }

}
