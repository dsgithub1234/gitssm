package com.itheima.dao;

import com.itheima.Permission;
import com.itheima.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {
    @Select("select * from role where id in(select roleid from users_role where userid=#{id})")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "permissions",column = "id",javaType =java.util.List.class,
            many = @Many(select = "com.itheima.dao.permissionsDao.findAll")
            )
    })

    List<Role>findById(String id);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role (roleName,roledesc)values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column ="id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType =java.util.List.class,
                    many = @Many(select = "com.itheima.dao.permissionsDao.findAll")
            )
    })
    Role findByRoleId(String iid);

    @Select("select * from permission where id not in(select permissionid from role_permission where roleid=#{id})")
    List<Permission> findPermissionById(String id);

    @Insert("insert into role_permission(permissionId,roleId)values(#{ids},#{roleId})")
    void addPermissionToRole(@Param("ids") String ids,@Param("roleId") String roleId);
}
