package me.www.web.service;

import me.www.web.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: www
 * @date: 2018/5/1 11:07
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void save() {
        Product product = new Product("apple", 10.8, "my apple");
        System.out.println(productService.save(product));
        System.out.println(product.getId());
    }

    @Test
    public void removeById() {
        productService.removeById(1);
    }

    @Test
    public void update() {
        Product product = new Product("watermelon", 5.06, "西瓜");
        product.setId(2);
        productService.update(product);
    }

    @Test
    public void getById() {
        System.out.println(productService.getById(2));
    }

    @Test
    public void listAll() {
        System.out.println(productService.listAll());
    }
}