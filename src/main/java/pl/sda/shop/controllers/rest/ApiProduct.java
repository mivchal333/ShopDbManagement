package pl.sda.shop.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.shop.domain.Product;
import pl.sda.shop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class ApiProduct {
    @Autowired
    ProductService service;

    @RequestMapping("all/")
    public List<Product> getAllProducts(){
        return service.listAllProducts();
    }

}
