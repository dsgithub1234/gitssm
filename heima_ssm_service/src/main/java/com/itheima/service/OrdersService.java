package com.itheima.service;

import com.itheima.Orders;

import java.util.List;

public interface OrdersService {

List<Orders>findAll(Integer page,Integer size);


    Orders findById(String id);
}
