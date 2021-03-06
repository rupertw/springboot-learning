package me.www.web.controller;

import me.www.web.model.Product;
import me.www.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: www
 * @date: 2018/5/1 15:32
 * @description: TODO
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/products")
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping(value = "/products/{id}")
    public void removeById(@PathVariable("id") Long id) {
        productService.removeById(id);
    }

    @PutMapping(value = "/products")
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

    @GetMapping(value = "/products/{id}")
    public Product getById(@PathVariable("id") Long id, HttpServletResponse response) {
        Product product = productService.getById(id);
        if (product == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }

        return product;
    }

    @GetMapping(value = "/products")
    public List<Product> listAll() {
        return productService.listAll();
    }

}
