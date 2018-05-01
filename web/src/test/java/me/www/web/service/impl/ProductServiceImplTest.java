package me.www.web.service.impl;

import me.www.web.model.Product;
import me.www.web.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: www
 * @date: 2018/5/1 15:38
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

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
        productService.removeById(9L);
    }

    @Test
    public void update() {
        Product product = new Product("watermelon", 6.8, "西瓜");
        product.setId(2L);
        productService.update(product);
    }

    @Test
    public void getById() {
        System.out.println(productService.getById(2L));
    }

    @Test
    public void listAll() {
        System.out.println(productService.listAll());
    }

}