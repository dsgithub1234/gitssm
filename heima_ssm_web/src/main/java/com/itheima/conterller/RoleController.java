package com.itheima.conterller;

import com.itheima.Permission;
import com.itheima.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Role> roles = roleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam("id") String Iid){
        ModelAndView mv=new ModelAndView();
     Role role=  roleService.findByRoleId(Iid);
      mv.addObject("role",role);
      mv.setViewName("role-show");
      return mv;
    }

    /*
    根据角色id查询所没有的权限
     */
    @RequestMapping("/findPermissionById.do")
    public ModelAndView findPermissionById(String id){
        ModelAndView mv=new ModelAndView();
     Role role= roleService.findByRoleId(id);
     List<Permission>permissions= roleService.findPermissionById(id);
     mv.addObject("role",role);
     mv.addObject("permissionList",permissions);
     mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(String ids,String roleId){
            roleService.addPermissionToRole(ids,roleId);
            return "redirect:findAll.do";
    }

}
