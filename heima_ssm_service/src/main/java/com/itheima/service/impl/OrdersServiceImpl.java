package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.Orders;
import com.itheima.dao.OrdersDao;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao dao;

    @Override

    public List<Orders> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return dao.findById(id);
    }
}
