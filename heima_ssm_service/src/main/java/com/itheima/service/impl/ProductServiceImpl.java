package com.itheima.service.impl;

import com.itheima.Product;
import com.itheima.dao.ProductDao;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    @RolesAllowed("admin")
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    @Secured("ROLE_user")
    public void save(Product product) {
        productDao.save(product);
    }
}
