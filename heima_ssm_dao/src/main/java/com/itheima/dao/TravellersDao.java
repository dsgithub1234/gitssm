package com.itheima.dao;

import com.itheima.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellersDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller>findAllById(String ordersId);

}
