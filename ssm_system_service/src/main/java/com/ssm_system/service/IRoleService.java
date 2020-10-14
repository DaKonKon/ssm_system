package com.ssm_system.service;

import com.ssm_system.dao.IRoleDao;
import com.ssm_system.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;
}
