package com.java.hodipg.controller;

import com.java.hodipg.dto.PopupDto;
import com.java.hodipg.service.PopupService;
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
public class PopupController {

    @Autowired
    PopupService popupService;

    @RequestMapping("/admin/popup/list_popup")
    public String list_popup(@RequestParam(defaultValue ="1")int page,
                             String category, String word, Model model){

        HashMap<String, Object> map = popupService.selectAll(page,category,word);

        model.addAttribute("popup",map.get("popup"));

        model.addAttribute("page", map.get("page"));
        model.addAttribute("listCount", map.get("listCount"));
        model.addAttribute("startPage", map.get("startPage"));
        model.addAttribute("endPage", map.get("endPage"));
        model.addAttribute("maxPage", map.get("maxPage"));

        model.addAttribute("category",map.get("category"));
        model.addAttribute("word",map.get("word"));


        return "admin/popup/list_popup";
    }

    @RequestMapping("/admin/popup/view_popup")
    public String view_popup(@RequestParam(defaultValue = "1")int pno,
                             @RequestParam(defaultValue = "1") int page,
                             String category, String word, Model model){
        HashMap<String, Object> map = popupService.selectOne(pno);

        model.addAttribute("pdto",map.get("popupDto"));

        model.addAttribute("category",category);
        model.addAttribute("word",word);
        model.addAttribute("page", page);

        return "admin/popup/view_popup";
    }

    @GetMapping("/admin/popup/write_popup")
    public String write_popup(){
        return "admin/popup/write_popup";
    }

    @PostMapping("/admin/popup/write_popup")
    public String write_news(PopupDto pdto, @RequestParam(value = "file" , required = false) MultipartFile file) throws Exception {

        String filename = null;
        if(!file.isEmpty()){
            String original = file.getOriginalFilename();
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmmss"));
            filename = time+"_"+original;
            String uploadurl = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\image\\popup\\";
            File f = new File(uploadurl + filename);
            file.transferTo(f);
        }
        pdto.setPfile(filename);
        popupService.insertOne(pdto);
        return "redirect:list_popup";
    }

    @RequestMapping("/admin/popup/delete_popup")
    public String delete_popup(int pno){
        popupService.deleteOne(pno);
        return "redirect:list_popup";
    }

    @GetMapping("/admin/popup/update_popup")
    public String update_popup(int pno, Model model){

        HashMap<String, Object> map = popupService.selectOne(pno);
        model.addAttribute("pdto", map.get("popupDto"));

        return "admin/popup/update_popup";
    }

    @PostMapping("/admin/popup/update_popup")
    public String update_popup(PopupDto pdto, @RequestParam(value = "file" , required = false) MultipartFile file) throws Exception {

        String filename = null;
        if(!file.isEmpty()){
            String original = file.getOriginalFilename();
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HHmmss"));
            filename = time+"_"+original;
            String uploadurl = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\image\\popup\\";
            File f = new File(uploadurl + filename);
            file.transferTo(f);
            pdto.setPfile(filename);
        }
        popupService.updateOne(pdto);
        return "redirect:list_popup";
    }

}
