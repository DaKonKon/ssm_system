package com.ssm_system.controller;

import com.github.pagehelper.PageInfo;
import com.ssm_system.domain.Orders;
import com.ssm_system.service.IOrdersService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;


    //查询全部订单 未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAl() throws Exception {
//        ModelAndView mv = new ModelAndView();
//
//        List<Orders> orderList = ordersService.findAll();
//        mv.addObject("ordersList",orderList);
//        mv.setViewName("orders-list");
//        return mv;
//    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required=true,defaultValue = "1") int page,@RequestParam(name="size",required = true,defaultValue = "4") int size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,size);
        //分页bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
}
