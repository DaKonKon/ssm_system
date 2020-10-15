package com.ssm_system.controller;


import com.ssm_system.domain.Permission;
import com.ssm_system.domain.Role;
import com.ssm_system.service.IPermissionService;
import com.ssm_system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired()
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    //查询所有角色
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    //添加角色
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }

    //根据ID查询角色
    @RequestMapping("/findById.do")
    public ModelAndView findById(int id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }


    //删除角色
    @RequestMapping("/deleteRole.do")
    public String delete(int id) throws Exception {
        roleService.delete(id);
        return "redirect:findAll.do";
    }

    //给角色添加权限 第一步
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(int id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    //给角色添加权限 第二步
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(int roleId,int ids[]) throws Exception {
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll.do";
    }
}
