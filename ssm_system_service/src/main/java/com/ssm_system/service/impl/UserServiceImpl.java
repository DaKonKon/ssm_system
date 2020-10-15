package com.ssm_system.service.impl;

import com.ssm_system.dao.IUserDao;
import com.ssm_system.domain.Role;
import com.ssm_system.domain.UserInfo;
import com.ssm_system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //登录时用户权限封装
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
             userInfo = userDao.findByUsername(username);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //把自己的用户信息封装到UserDetails
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthorities(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getAuthorities(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roles ){
        List<SimpleGrantedAuthority> list= new ArrayList<>();
        for(Role role:roles){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
            list.add(authority);
        }
        return  list;
    }


    //查询所有用户
    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }


    //添加用户时对密码加密
    @Override
    public void save(UserInfo user) throws Exception {
        String newPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(newPassword);
        userDao.save(user);
    }


    //根据ID查询user
    @Override
    public UserInfo findById(int id) throws Exception {
        UserInfo userInfo = userDao.findById(id);
        return userInfo;
    }

    @Override
    public void addRoleToUser(int userId, int[] ids) throws Exception {
        for(int roleId:ids){
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
