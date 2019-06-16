package com.itheima.dao;

import com.itheima.Member;
import com.itheima.Orders;
import com.itheima.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",
            javaType = Product.class,one=@One(select ="com.itheima.dao.ProductDao.findById"))
    })
     List<Orders> findAll();


    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",
                    javaType = Product.class,
                    one = @One(select = "com.itheima.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,
                    one = @One(select = "com.itheima.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class,
                    many = @Many(select = "com.itheima.dao.TravellersDao.findAllById"))
    })
    Orders findById(String id);
}
