package com.itheima.dao;

import com.itheima.Role;
import com.itheima.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id =true, property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.dao.RoleDao.findById")
            )
    })
    UserInfo findAllByUsername(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id =true, property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.dao.RoleDao.findById"))
    })
    UserInfo findById(String id);

    @Insert("insert into users(email,username,password,phonenum,status)values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from role where id not in(select roleid from users_role where userid=#{id})")
    List<Role> findOtherRoles(String id);

    @Insert("insert into users_role(userid,roleid)values(#{userId},#{ids})")
    void addRoleToUser(@Param("userId") String userId,@Param("ids") String ids);
}
