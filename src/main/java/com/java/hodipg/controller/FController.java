package com.java.hodipg.controller;

import com.java.hodipg.dto.MemberDto;
import com.java.hodipg.dto.PopupDto;
import com.java.hodipg.service.MemberService;
import com.java.hodipg.service.PopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class FController {

    @Autowired
    MemberService memberService;

    @Autowired
    PopupService popupService;

    @Autowired
    HttpSession session;

    @RequestMapping("/index")
    public String index(Model model){

//        HashMap<String, Object> map = popupService.selectPopup();
//        model.addAttribute("pdto",map.get("popupDto"));

        return "index";
    }

    @RequestMapping("/admin")
    public String admin(){ return "admin"; }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(MemberDto memberDto, Model model){
        MemberDto mdto = memberService.selectLogin(memberDto);

        if(mdto != null){
            session.setAttribute("sessionId", mdto.getId());
            session.setAttribute("sessionName", mdto.getName());
            session.setAttribute("sessionLevel", mdto.getLevel());
        } else {
            model.addAttribute("loginCheck", "fail");
            return "/login";
        }
        return "redirect:/index";
    }

    @RequestMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/index";
    }
}
