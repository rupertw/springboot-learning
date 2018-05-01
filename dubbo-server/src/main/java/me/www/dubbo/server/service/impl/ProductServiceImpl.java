package me.www.dubbo.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import me.www.dubbo.api.model.Product;
import me.www.dubbo.api.service.ProductService;

/**
 * @author: www
 * @date: 2018/5/1 20:54
 * @description: TODO
 */
@Service(version = "1.0.0")
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getById(Long id) {
        Product product = new Product("apple", 10.8, "my apple");
        product.setId(id);

        return product;
    }
}
