package me.www.web.service;

import me.www.web.dao.ProductDao;
import me.www.web.model.Product;
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
public class ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * 保存
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer save(Product product) {
        Integer result = productDao.save(product);

        //throw new RuntimeException("事务测试");

        return result;
    }


    /**
     * 删除单条记录
     *
     * @param id
     */
    public void removeById(Integer id) {
        productDao.removeById(id);
    }

    /**
     * 更新记录
     *
     * @param product
     */
    public void update(Product product) {
        productDao.update(product);
    }

    /**
     * 查
     *
     * @param id
     * @return
     */
    public Product getById(Integer id) {
        return productDao.getById(id);
    }

    /**
     * 查询所有记录
     *
     * @return
     */
    public List<Product> listAll() {
        return productDao.listAll();
    }

}
