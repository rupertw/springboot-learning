package me.www.web.service.impl;

import me.www.web.dao.ProductDao;
import me.www.web.model.Product;
import me.www.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: www
 * @date: 2018/5/1 10:45
 * @description: TODO
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer save(Product product) {
        Integer result = productDao.save(product);

        //throw new RuntimeException("数据库事务测试");

        return result;
    }

    @Override
    public void removeById(Long id) {
        productDao.removeById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> listAll() {
        return productDao.listAll();
    }

}
