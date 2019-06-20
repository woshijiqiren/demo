package com.zr.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping("/wwj")
    public String  index(){
        return "wwj";
    }
    
    @RequestMapping("/wwj1")
    public ModelAndView  index1(){
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("xxx", "xxxx");
    	mv.setViewName("wwj1");
        return mv;
    }
}
