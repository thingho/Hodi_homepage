package com.java.hodipg.controller;

import com.java.hodipg.dto.NewsDto;
import com.java.hodipg.service.NewsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Controller
public class NewsController {

    @Autowired
    NewsSerivce newsSerivce;

    @RequestMapping("/menu/community/news/list_news")
    public String list_news(@RequestParam(defaultValue ="1")int page,
                            String category, String word, Model model){

        HashMap<String, Object> map = newsSerivce.selectAll(page,category,word);

        model.addAttribute("news",map.get("news"));

        model.addAttribute("page", map.get("page"));
        model.addAttribute("listCount", map.get("listCount"));
        model.addAttribute("startPage", map.get("startPage"));
        model.addAttribute("endPage", map.get("endPage"));
        model.addAttribute("maxPage", map.get("maxPage"));

        model.addAttribute("category",map.get("category"));
        model.addAttribute("word",map.get("word"));

        return "menu/community/news/list_news";
    }

    @RequestMapping("/menu/community/news/view_news")
    public String view_news(@RequestParam(defaultValue = "1")int nno,
                            @RequestParam(defaultValue = "1") int page,
                            String category, String word, Model model){
        HashMap<String, Object> map = newsSerivce.selectOne(nno);

        model.addAttribute("ndto",map.get("newsDto"));

        model.addAttribute("category",category);
        model.addAttribute("word",word);
        model.addAttribute("page", page);
        return "menu/community/news/view_news";
    }

    @GetMapping("/menu/community/news/write_news")
    public String write_news(){
        return "menu/community/news/write_news";
    }

    @PostMapping("/menu/community/news/write_news")
    public String write_news(NewsDto ndto, @RequestParam(value = "file" , required = false) MultipartFile file) throws Exception {

        String filename = null;
        if(!file.isEmpty()){
            String original = file.getOriginalFilename();
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmmss"));
            filename = time+"_"+original;
            /*String uploadurl = "c://workspace/images/";*/
            String uploadurl = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\image\\news\\";
            File f = new File(uploadurl + filename);
            file.transferTo(f);
            System.out.println(uploadurl);
        }
        ndto.setNfile(filename);
        newsSerivce.insertOne(ndto);
        return "redirect:list_news";
    }

    @RequestMapping("/menu/community/news/delete_news")
    public String delete_news(int nno){
        newsSerivce.deleteOne(nno);
        return "redirect:list_news";
    }

    @GetMapping("/menu/community/news/update_news")
    public String update_news(int nno, Model model){

        HashMap<String, Object> map = newsSerivce.selectOne(nno);
        model.addAttribute("ndto", map.get("newsDto"));

        return "menu/community/news/update_news";
    }

    @PostMapping("/menu/community/news/update_news")
    public String update_news(NewsDto ndto, @RequestParam(value = "file" , required = false) MultipartFile file) throws Exception {

        String filename = null;
        if(!file.isEmpty()){
            String original = file.getOriginalFilename();
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmmss"));
            filename = time+"_"+original;
            /*String uploadurl = "c://workspace/images/";*/
            String uploadurl = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\image\\news\\";
            File f = new File(uploadurl + filename);
            file.transferTo(f);
        }
        ndto.setNfile(filename);
        newsSerivce.updateOne(ndto);
        return "redirect:list_news";
    }

}
