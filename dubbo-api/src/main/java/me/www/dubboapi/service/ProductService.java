package me.www.dubboapi.service;

import me.www.dubboapi.model.Product;

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

