package com.itheima.dao;

import com.itheima.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermDao {

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission permission(permissionname,url)values(#{permissionName},#{url})")
    void save(Permission permission);
}
