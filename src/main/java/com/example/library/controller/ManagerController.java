package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.domain.Manager;
import com.example.library.domain.Reader;
import com.example.library.mapper.BorrowMapper;
import com.example.library.service.BookService;
import com.example.library.service.ManagerService;
import com.example.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private  ReaderService readerService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowMapper borrowMapper;
//    @PostMapping("/login/LoginIn1")
//    public String mA(String username, String pwd){
//        boolean b=managerService.isTure(username,pwd);
//        System.out.println(b);
//        return "";
//    }
    @GetMapping("/manager/man")
    public String manager1(Model model) {
        List<Manager> managerList=managerService.findAll();
        model.addAttribute("managerList",managerList);
        System.out.println(managerList.get(0));
        return "m_1";
        //员工管理页面
    }
    @PostMapping("/manager/search")
    public String manager4(Model model,String name) {
        List<Manager> managerList= managerService.findByNames("%"+name+"%");
        model.addAttribute("managerList",managerList);
        return "m_1";
        //员工管理页面通过名字查询
    }
    @PostMapping("/manager/Usearch")
    public String manager5(Model model,String name) {
        List<Reader> readerList= readerService.findByNames("%"+name+"%");
        model.addAttribute("readerList",readerList);
        return "m_2";
        //管理身份用户管理页面查询跳转
    }
    @PostMapping("/manager/Bsearch")
    public String manager6(Model model,String name) {
        List<Book> bookList= bookService.findByNames("%"+name+"%");
        model.addAttribute("bookList",bookList);
        return "m_3";
    //管理身份图书管理页面查询跳转
    }
    @GetMapping("/manager/user")
    public String manager2(Model model) {
        List<Reader> readerList= readerService.queryAll();
        model.addAttribute("readerList",readerList);
        return "m_2";
//        管理员身份用户管理跳转
    }

    @GetMapping("/manager/book")
    public String manager3(Model model) {
       List<Book> bookList= bookService.findAll();
        model.addAttribute("bookList",bookList);
        return "m_3";
//        管理员图书管理
    }

    @PostMapping("/manager/add")
    public String manager7(String name ,String pwd) {
        Manager m=new Manager();
        m.setM_name(name);
        m.setM_pw(pwd);
        managerService.save(m);
        return "redirect:/manager/man";
//        管理员身份 加入成员
    }
    @GetMapping("/manager/delete")
    public String manager8(@RequestParam("id") Integer id ) {
        managerService.delete(id);
        return "redirect:/manager/man";
        //        管理员身份 加入成员

    }
    @GetMapping("/manager/Myuser")
    public String manger9(Model model) {
        return "m_4";
    }

    @GetMapping("/manager/back")
    public String manager10(Model model) {
        List<Map> borrowList=borrowMapper.findAll();
        model.addAttribute("borrowList",borrowList);
        return "m_5";
        //        管理员身份 加入成员

    }
}
