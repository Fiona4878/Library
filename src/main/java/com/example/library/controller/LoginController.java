package com.example.library.controller;

import com.example.library.domain.Reader;
import com.example.library.service.ManagerService;
import com.example.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;

@Controller
public class LoginController {
    @Autowired
    private ReaderService readerService;
    @Autowired
    private ManagerService managerService;

    @PostMapping("/login/LoginIn1")
    public String LoginIn1(String username,String pwd,HttpServletRequest request) {
        boolean b=managerService.isTure(username,pwd);
        System.out.println(b);
        String url="";
        if(b){
            url= "main";
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("pwd",pwd);
        }else{
            url= "login";
        }
        return url;
    }
    @RequestMapping("/login/LoginIn")
    public String LoginIn2(String username,String pwd,HttpServletRequest request) {
        Boolean b=readerService.isTure(username,pwd);
        String url="";
        if(b){
            url= "main1";
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("pwd",pwd);
        }else{
            url= "login1";
        }
        return url;
    }

//    国际化跳转
@GetMapping("/toLoginPage")
public String login(Model model) {
    model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
      return "login";
    }
    //去身份不同的登录页面
    @GetMapping("/toLoginPage/{id}")
    public String login1(Model model,@PathVariable("id") Integer id ) {
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        if(id==1){
            return "login";
        }else{
            return "login1";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }

//    //    页面链接跳转页面
//    @RequestMapping(value = "/toPage", method = RequestMethod.GET)
//    public String toPage(HttpServletRequest request) {
//        String url = request.getParameter("url");
//        return url;
//        //去url.html页面
//    }


}
