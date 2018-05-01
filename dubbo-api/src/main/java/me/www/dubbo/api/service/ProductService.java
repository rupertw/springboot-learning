package me.www.dubbo.api.service;


import me.www.dubbo.api.model.Product;

/**
 * @author: www
 * @date: 2018/5/1 15:34
 * @description: TODO
 */
public interface ProductService {

    /**
     * 查
     *
     * @param id
     * @return
     */
    Product getById(Long id);

}

