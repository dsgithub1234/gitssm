package com.itheima.conterller;

import com.itheima.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/product")
public class ProductConterller {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")

    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 保存
     */
    @RequestMapping("/save.do")
    public String save(Product product){

        productService.save(product);
        return "redirect:/product/findAll.do";
    }

}
