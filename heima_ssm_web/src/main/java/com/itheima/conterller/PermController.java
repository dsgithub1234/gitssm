package com.itheima.conterller;

import com.itheima.Permission;
import com.itheima.service.PermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermController {
    @Autowired
    private PermService permService;

    @RequestMapping("/findPermission.do")
    public ModelAndView findByRoleId(){
        ModelAndView mv=new ModelAndView();
        List<Permission> role=  permService.findAll();
        mv.addObject("permissionList",role);
        mv.setViewName("permission-add");
        return mv;
    }
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Permission> permissions = permService.findAll();
        mv.addObject("permissionList",permissions);
        mv.setViewName("permission-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Permission permission){

         permService.save(permission);

        return "redirect:findAll.do";
    }
}
