package com.itheima.service.impl;

import com.itheima.Permission;
import com.itheima.Role;
import com.itheima.dao.RoleDao;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {

        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findByRoleId(String iid) {
        return roleDao.findByRoleId(iid);
    }

    @Override
    public Role findById(String id) {
        return null;
    }


    @Override
    public List<Permission> findPermissionById(String id) {
        return roleDao.findPermissionById(id);
    }

    @Override
    public void addPermissionToRole(String ids, String roleId) {
        roleDao.addPermissionToRole(ids,roleId);
    }
}
