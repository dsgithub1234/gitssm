package com.itheima.dao;

import com.itheima.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface permissionsDao {

    @Select("select * from permission where id in(select permissionid from role_permission where roleid=#{id})")
    List<Permission> findAll(String id);
}
