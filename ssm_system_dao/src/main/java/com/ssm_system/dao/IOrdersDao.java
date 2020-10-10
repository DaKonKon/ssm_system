package com.ssm_system.dao;

import com.ssm_system.domain.Member;
import com.ssm_system.domain.Orders;
import com.ssm_system.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "product",column = "productId",javaType = Product.class,one=@One(select = "com.ssm_system.dao.IProductDao.findById")),
            @Result(property = "orderNum",column = "orderNum"),
    })
    List<Orders> findAll() throws Exception;


    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.ssm_system.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.ssm_system.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class, many = @Many(select = "com.ssm_system.dao.ITravellerDao.findByOrderId"))


    })
    Orders findById(Integer id) throws Exception;
}
