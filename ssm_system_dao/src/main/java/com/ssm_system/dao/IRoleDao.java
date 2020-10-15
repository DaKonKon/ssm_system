package com.ssm_system.dao;

import com.ssm_system.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

public interface IRoleDao {


    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ssm_system.dao.IPermissionDao.findByRoleId"))

    })
    public List<Role> findRoleByUserId(int userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;


    @Insert("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role);



    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ssm_system.dao.IPermissionDao.findByRoleId"))
    })
    Role findById(int id);

    @Update("delete  from role where id = #{roleId}")
    void delete(int roleId);

    @Update("delete from users_role where roleId = #{roleId}")
    void deleteFromUsers_RoleByRoleId(int roleId);

    @Update("delete from role_permission where roleId = #{roleId}")
    void deleteFromRole_PermissionByRoleId(int roleId);

    @Insert("insert into role_permission (permissionId,roleId) values (#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") int roleId,@Param("permissionId") int permissionId);


    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoleByUserId(int userId);
}
