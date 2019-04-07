package pl.sda.shop.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.shop.domain.Product;
import pl.sda.shop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ApiProduct {

    @Autowired
    ProductService service;

    @RequestMapping(value = "/all")
    public List<Product> getAllProducts(){
        System.out.println(service.listAllProducts());
        return service.listAllProducts();
    }

}
