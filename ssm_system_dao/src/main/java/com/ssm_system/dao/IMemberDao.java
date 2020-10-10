package com.ssm_system.dao;

import com.ssm_system.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    @Select("select * from `member` where id = #{memberId}")
    public Member findById(Integer memberId) throws Exception;
}
