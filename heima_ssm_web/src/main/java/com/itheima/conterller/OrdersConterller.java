package com.itheima.conterller;

import com.github.pagehelper.PageInfo;
import com.itheima.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersConterller {
    @Autowired
    private OrdersService ordersService;

   /* @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Orders> orders = ordersService.findAll();
        mv.addObject("ordersList",orders);
        mv.setViewName("orders-list");
        return mv;
    }*/
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam("page")Integer page,@RequestParam("size") Integer size){
        List<Orders> orders = ordersService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(orders);
        ModelAndView mv=new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam("id") String id){
            ModelAndView mv=new ModelAndView();
         Orders orders=  ordersService.findById(id);
         mv.addObject("orders",orders);
         mv.setViewName("orders-show");
         return mv;
    }
}
