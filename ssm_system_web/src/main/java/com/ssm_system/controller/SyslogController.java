package com.ssm_system.controller;

import com.ssm_system.domain.Syslog;
import com.ssm_system.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SyslogController {

    @Autowired
     private ISysLogService sysLogService;
    
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Syslog> syslogs = sysLogService.findAll();
        mv.addObject("sysLogs",syslogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
