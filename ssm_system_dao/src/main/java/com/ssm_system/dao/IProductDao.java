package com.ssm_system.dao;

import com.ssm_system.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {


    //查询所有
    @Select("select * from product")
    public List<Product> findAll() throws Exception;


    //添加
    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values" +
            "(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(Product product)throws Exception;


    //根据ID查询
    @Select("select * from product where id = #{id}")
    public Product findById(Integer id) throws Exception;
}
