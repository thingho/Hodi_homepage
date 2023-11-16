package com.java.hodipg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin/adminindex")
    public String adminindex(){
        return "admin/adminindex";
    }
    @RequestMapping("/admin/adminMain")
    public String adminMain(){
        return "admin/adminMain";
    }

    @RequestMapping("/admin/newsWrite")
    public String newsWrite(){
        return "admin/newsWrite";
    }

    @RequestMapping("/admin/newsUpdate")
    public String newsUpdate(){
        return "admin/newsUpdate";
    }
}
