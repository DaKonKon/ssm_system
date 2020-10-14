package com.ssm_system.service;

import com.ssm_system.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<UserInfo > findAll() throws Exception;

    public void save(UserInfo user) throws Exception;

    UserInfo findById(int id) throws Exception;
}
