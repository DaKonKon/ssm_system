package com.ssm_system.service.impl;

import com.ssm_system.dao.IRoleDao;
import com.ssm_system.domain.Role;
import com.ssm_system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
