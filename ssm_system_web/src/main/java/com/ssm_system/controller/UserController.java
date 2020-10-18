package com.ssm_system.controller;

import com.ssm_system.domain.Role;
import com.ssm_system.domain.UserInfo;
import com.ssm_system.service.IRoleService;
import com.ssm_system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService ;

    @Autowired
    IRoleService roleService;

    @RequestMapping("/findAll.do")

    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return  mv;
    }


    //添加用户
    @RequestMapping("/save.do")
    public String  save(UserInfo user) throws Exception {
        userService.save(user);
        return "redirect:findAll.do";
    }

    //查询指定ID的用户
    @RequestMapping("/findById.do")
    public ModelAndView findById(int id) throws Exception {
        UserInfo userInfo = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-show");
        mv.addObject("user",userInfo);
        return  mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(int id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        List<Role> roleList = roleService.findOtherRoleByUserId(id);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name="userId",required = true) int userId, @RequestParam(name="ids",required = true) int[] ids) throws Exception {
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }
}
