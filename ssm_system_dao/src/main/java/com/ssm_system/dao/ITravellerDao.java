package com.ssm_system.dao;

import com.ssm_system.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{orderId})")
    public List<Traveller> findByOrderId(Integer orderId);
}
