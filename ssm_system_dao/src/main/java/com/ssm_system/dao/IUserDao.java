package com.ssm_system.dao;

import com.ssm_system.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "email",property = "email"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType =java.util.List.class ,many = @Many(select = "com.ssm_system.dao.IRoleDao.findRoleByUserId"))
            }
    )
    public UserInfo findByUsername(String username) throws Exception;


    @Select("select * from users")
    public List<UserInfo> findAll();

    @Insert("insert into users (id,email,username,password,status,phoneNum) values(#{id},#{email},#{username},#{password},#{status},#{phoneNum})")
    public void save(UserInfo user) throws Exception;


    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "status",column = "status"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "roles",column = "id",javaType=java.util.List.class,many = @Many(select = "com.ssm_system.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(int id);

    @Insert("insert into users_role (userId,roleId) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") int userId,@Param("roleId") int roleId);


}
