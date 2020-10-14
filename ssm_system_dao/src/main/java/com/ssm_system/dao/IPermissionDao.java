package com.ssm_system.dao;

import com.ssm_system.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from permission where id in (select  permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findByRoleId(int roleId);

}
