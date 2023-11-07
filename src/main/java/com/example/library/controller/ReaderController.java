package com.example.library.controller;

import com.example.library.domain.Reader;
import com.example.library.service.BookService;
import com.example.library.service.ManagerService;
import com.example.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReaderController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private ReaderService readerService;
    @Autowired
    private BookService bookService;
//    管理员 用户 添加
    @PostMapping("/reader/add")
    public String reader1(String name ,String sex,String phone,String pwd) {
        Reader r=new Reader();
        r.setR_name(name);
        r.setR_sex(sex);
        r.setR_phone(phone);
        r.setR_pw(pwd);
        System.out.println(r);
        readerService.save(r);
        return "redirect:/manager/user";
    }
    //    管理员 用户 删除
    @GetMapping("/reader/delete")
    public String reader2(@RequestParam("id") Integer id ) {
        readerService.delete(id);
        return "redirect:/manager/user";
    }
    //    管理员 用户 修改
    @PostMapping("/reader/edit")
    public String reader3(String id,String name ,String sex,String phone,String pwd) {
        Reader r=new Reader();
        System.out.println(id);
        r.setR_id(Integer.parseInt(id));
        r.setR_name(name);
        r.setR_sex(sex);
        r.setR_phone(phone);
        r.setR_pw(pwd);
        readerService.edit(r);
    return "redirect:/manager/user";
    }
}
