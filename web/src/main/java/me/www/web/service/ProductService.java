package me.www.web.service;

import me.www.web.model.Product;

import java.util.List;

/**
 * @author: www
 * @date: 2018/5/1 15:34
 * @description: TODO
 */
public interface ProductService {

    /**
     * 保存
     */
    Integer save(Product product);


    /**
     * 删除单条记录
     *
     * @param id
     */
    void removeById(Long id);

    /**
     * 更新记录
     *
     * @param product
     */
    void update(Product product);

    /**
     * 查
     *
     * @param id
     * @return
     */
    Product getById(Long id);

    /**
     * 查询所有记录
     *
     * @return
     */
    List<Product> listAll();

}
