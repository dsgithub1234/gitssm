package com.itheima.service.impl;

import com.itheima.Permission;
import com.itheima.dao.PermDao;
import com.itheima.service.PermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermServiceImpl implements PermService {
    @Autowired
    private PermDao permDao;
    @Override
    public List<Permission> findAll() {
        return permDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permDao.save(permission);
    }
}
