package com.ssm_system.dao;

import com.ssm_system.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from permission where id in (select  permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findByRoleId(int roleId);

    @Select("select * from permission")
    List<Permission> findAll();


    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    void Save(Permission permission);

    @Select("select * from permission where id = #{id}")
    Permission findById(int id);

    @Update("delete from permission where id = #{id}")
    void deletePermission(int id);

    @Update("delete from role_permission where permissionId = #{id}")
    void deleteFromRole_Permission (int id);
}
