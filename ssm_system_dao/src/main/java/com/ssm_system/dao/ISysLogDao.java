package com.ssm_system.dao;

import com.ssm_system.domain.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISysLogDao {
    @Insert("insert into syslog(Date,username,ip,url,executionTime,method) values (#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(Syslog syslog) throws Exception;

    @Select("select * from syslog")
    List<Syslog> findAll();
}
