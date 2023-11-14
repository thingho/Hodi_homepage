package com.java.hodipg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    @RequestMapping("/menu/news/list")
    public String list(){
        return "menu/news/list";
    }

    @RequestMapping("/menu/news/view")
    public String view(){
        return "menu/news/view";
    }

    @RequestMapping("/menu/news/write")
    public String write(){
        return "menu/news/write";
    }
}
