package com.java.hodipg.controller;

import com.java.hodipg.service.NewsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class NewsController {

    @Autowired
    NewsSerivce newsSerivce;

    @RequestMapping("/menu/notice/news/list_news")
    public String list_news(Model model){

        HashMap<String, Object> map = newsSerivce.selectAll();

        model.addAttribute("news",map.get("news"));

        return "menu/notice/news/list_news";
    }

    @RequestMapping("/menu/notice/news/view_news")
    public String view_news(@RequestParam(defaultValue = "1")int nno,Model model){
        HashMap<String, Object> map = newsSerivce.selectOne(nno);

        model.addAttribute("ndto",map.get("ndto"));
        return "menu/notice/news/view_news";
    }

    @RequestMapping("/menu/notice/news/update_news")
    public String update_news(){
        return "menu/notice/news/update_news";
    }

    @RequestMapping("/menu/notice/news/write_news")
    public String write_news(){
        return "menu/notice/news/write_news";
    }

}
