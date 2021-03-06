package com.ssm_system.controller;

import com.ssm_system.domain.Permission;
import com.ssm_system.service.IPermissionService;
import com.ssm_system.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissions = permissionService.findAll();
        mv.addObject("permissions",permissions);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(int id) throws Exception{
        ModelAndView mv= new ModelAndView();
        Permission p = permissionService.findById(id);
        mv.addObject("permission",p);
        mv.setViewName("permission-show");
        return mv;
    }

    @RequestMapping("/deletePermission")
    public String deletePermission(int id) throws Exception {
        permissionService.deletePermission(id);
        return "redirect:findAll.do";
    }
}
