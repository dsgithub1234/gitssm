package com.itheima.service;

import com.itheima.Permission;
import com.itheima.Role;

import java.util.List;

public interface RoleService {

    List<Role>findAll();

    void save(Role role);

      Role findByRoleId(String iid);

    Role findById(String id);

    List<Permission> findPermissionById(String id);

    void addPermissionToRole(String ids, String roleId);
}
