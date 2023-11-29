package com.java.hodipg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sub01Controller {

    @RequestMapping( "/menu/sub01/sub1")
    public String sub1(){
        return "menu/sub01/sub1";
    }

    @RequestMapping( "/menu/sub01/sub2")
    public String sub2(){
        return "menu/sub01/sub2";
    }

    @RequestMapping( "/menu/sub01/sub3")
    public String sub3(){
        return "menu/sub01/sub3";
    }

    @RequestMapping( "/menu/sub01/sub4")
    public String sub4(){
        return "menu/sub01/sub4";
    }

    @RequestMapping( "/menu/sub01/sub5")
    public String sub5(){
        return "menu/sub01/sub5";
    }

    @RequestMapping( "/menu/sub01/sub5_2")
    public String sub5_2(){
        return "menu/sub01/sub5_2";
    }


}
