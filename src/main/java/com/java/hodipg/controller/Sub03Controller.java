package com.java.hodipg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sub03Controller {

    @RequestMapping("/menu/sub03/sub1_1")
    public String sub1_1(){ return "menu/sub03/sub1_1"; }

    @RequestMapping("/menu/sub03/sub2_1")
    public String sub2_1(){ return "menu/sub03/sub2_1"; }

    @RequestMapping("/menu/sub03/sub3_1")
    public String sub3_1(){ return "menu/sub03/sub3_1"; }

    @RequestMapping("/menu/sub03/sub4_1")
    public String sub4_1(){ return "menu/sub03/sub4_1"; }

}
