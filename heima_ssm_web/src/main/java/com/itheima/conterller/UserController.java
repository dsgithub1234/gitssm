package com.itheima.conterller;

import com.itheima.Role;
import com.itheima.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")

    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<UserInfo> users= userService.findAll();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo=  userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show1");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save( UserInfo userInfo){
     userService.save(userInfo);
      return "redirect:findAll.do";
    }
    /*
    根据用户id查询其没有的角色
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo = userService.findById(id);
       List<Role>roles= userService.findOtherRole(id);
       mv.addObject("user",userInfo);
       mv.addObject("roleList",roles);
       mv.setViewName("user-role-add");
       return mv;

    }
    /*
    根据用户id添加角色
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(String userId,String ids){
     userService.addRoleToUser(userId,ids);

     return "redirect:findAll.do";
    }
}
