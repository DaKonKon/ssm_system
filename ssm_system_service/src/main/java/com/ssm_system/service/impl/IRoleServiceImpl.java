package com.ssm_system.service.impl;

import com.ssm_system.dao.IRoleDao;
import com.ssm_system.domain.Role;
import com.ssm_system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.List;
@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(int id) throws Exception {
        Role role = roleDao.findById(id);
        return role;
    }

    @Override
    public void delete(int id) throws Exception {
        roleDao.delete(id);
    }

    @Override
    public void addPermissionToRole(int roleId,int ids[]) throws Exception {
        for(int permissionId:ids){
            roleDao.addPermissionToRole(roleId,permissionId);
        }

    }


}
