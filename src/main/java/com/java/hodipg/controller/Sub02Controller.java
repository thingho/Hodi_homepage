package com.java.hodipg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sub02Controller {

    /*무인비대면솔루션 1*/
    @RequestMapping( "/menu/sub02/sub1_1")
    public String sub1_1(){
        return "menu/sub02/sub1_1";
    }

    @RequestMapping( "/menu/sub02/sub1_2")
    public String sub1_2(){
        return "menu/sub02/sub1_2";
    }

    @RequestMapping( "/menu/sub02/sub1_3")
    public String sub1_3(){
        return "menu/sub02/sub1_3";
    }

    @RequestMapping( "/menu/sub02/sub1_4")
    public String sub1_4(){
        return "menu/sub02/sub1_4";
    }


    /*도서관솔루션 2*/
    @RequestMapping( "/menu/sub02/sub2_1")
    public String sub2_1(){
        return "menu/sub02/sub2_1";
    }

    @RequestMapping( "/menu/sub02/sub2_2")
    public String sub2_2(){
        return "menu/sub02/sub2_2";
    }

    @RequestMapping( "/menu/sub02/sub2_3")
    public String sub2_3(){
        return "menu/sub02/sub2_3";
    }

    @RequestMapping( "/menu/sub02/sub2_4")
    public String sub2_4(){
        return "menu/sub02/sub2_4";
    }

    @RequestMapping( "/menu/sub02/sub2_5")
    public String sub2_5(){ return "menu/sub02/sub2_5"; }

    @RequestMapping( "/menu/sub02/sub2_6")
    public String sub2_6(){ return "menu/sub02/sub2_6"; }

    @RequestMapping( "/menu/sub02/sub2_7")
    public String sub2_7(){ return "menu/sub02/sub2_7"; }

    @RequestMapping( "/menu/sub02/sub2_8")
    public String sub2_8(){ return "menu/sub02/sub2_8"; }

    @RequestMapping( "/menu/sub02/sub2_9")
    public String sub2_9(){ return "menu/sub02/sub2_9"; }


    /*모바일솔루션 3*/
    @RequestMapping( "/menu/sub02/sub3_1")
    public String sub3_1(){ return "menu/sub02/sub3_1"; }

    @RequestMapping( "/menu/sub02/sub3_2")
    public String sub3_2(){ return "menu/sub02/sub3_2"; }

    @RequestMapping( "/menu/sub02/sub3_3")
    public String sub3_3(){
        return "menu/sub02/sub3_3";
    }

    @RequestMapping( "/menu/sub02/sub3_4")
    public String sub3_4(){
        return "menu/sub02/sub3_4";
    }


    /*보안솔루션 4*/
    @RequestMapping( "/menu/sub02/sub4_1")
    public String sub4_1(){
        return "menu/sub02/sub4_1";
    }

}
