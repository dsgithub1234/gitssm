package com.itheima.service;

import com.itheima.Role;
import com.itheima.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{


    List<UserInfo> findAll();

    UserInfo findById(String id);

    void save(UserInfo userInfo);

    List<Role> findOtherRole(String id);


    void addRoleToUser(String userId, String ids);
}
