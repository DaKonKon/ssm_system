package com.ssm_system.service;

import com.ssm_system.domain.Orders;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(int id) throws Exception;
}
