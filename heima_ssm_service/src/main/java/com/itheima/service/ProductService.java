package com.itheima.service;

import com.itheima.Product;

import java.util.List;

public interface ProductService {
    List<Product>findAll();

    void save(Product product);
}
