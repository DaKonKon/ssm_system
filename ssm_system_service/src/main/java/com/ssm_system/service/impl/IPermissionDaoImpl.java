package com.ssm_system.service.impl;

import com.ssm_system.dao.IPermissionDao;
import com.ssm_system.domain.Permission;
import com.ssm_system.domain.Product;
import com.ssm_system.service.IPermissionService;
import com.ssm_system.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IPermissionDaoImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;


    @Override
    public List<Permission> findAll() throws Exception{
        List<Permission> permissions = permissionDao.findAll();
        return permissions;
    }

    @Override
    public void save(Permission permission) throws Exception{
        permissionDao.Save(permission);
    }
}
