package com.itheima.service;

import com.itheima.Permission;

import java.util.List;

public interface PermService {

    List<Permission>findAll();

    void save(Permission permission);
}
