package pl.sda.shop.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.shop.domain.Product;
import pl.sda.shop.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ApiProduct {

    @Autowired
    ProductService service;

    @RequestMapping(value = "/all")
    public List<Product> getAllProducts() {
        return service.listAllProducts();
    }

    @RequestMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable Integer id) {
        Optional<Product> productOpt = service.getProductById(id);
        if (productOpt.isPresent()) {
            return new ResponseEntity(productOpt.get(), HttpStatus.I_AM_A_TEAPOT);
        } else return new ResponseEntity("Product not found", HttpStatus.BAD_REQUEST);
    }

}
