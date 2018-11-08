package io.dreamstudio.springboot.cache.service;

import io.dreamstudio.springboot.cache.model.Product;

/**
 * @author Ricky Fung
 */
public interface ProductService {

    Product saveOrUpdate(Product product);

    Product get(Long id);

    boolean delete(Long id);

}
