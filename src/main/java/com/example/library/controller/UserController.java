package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.domain.Manager;
import com.example.library.domain.Reader;
import com.example.library.domain.bookDTO;
import com.example.library.mapper.BookMapper;
import com.example.library.mapper.BorrowMapper;
import com.example.library.service.BookService;
import com.example.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ReaderService readerService;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BorrowMapper borrowMapper;

    @GetMapping("/user/books")
    public String user1(Model model) {
        List<Book> bookList= bookMapper.findBook();
        model.addAttribute("bookList",bookList);
        return "r_1";
//        用户 图书管理页面跳转
    }
//    今日推荐
    @GetMapping("/user/today")
    public String user2(Model model) {
        return "main1";
    }

    @PostMapping("/user/Bsearch")
    public String user7(Model model,String name) {
        List<Book> bookList= bookService.findByNames("%"+name+"%");
        model.addAttribute("bookList",bookList);
        return "r_1";
        //        用户 图书管理页面查询跳转

    }
    @GetMapping("/user/borrow")
    public String user4(@RequestParam("id") Integer id,@RequestParam("user") String user) {
//        获取当前图书id，与登录账户id
        Reader r=readerService.findByName(user);
        Integer r_id=r.getR_id();
        borrowMapper.insertBorrow(id,r_id);
//        增加借阅的同时，该图书的数量减1；
        Book book=bookMapper.findById(id);
        book.setB_exit(book.getB_exit()-1);
        bookMapper.updateBook(book);
        return "redirect:/user/borrows?user="+user;
    }

    @GetMapping("/user/borrows")
    public String user8(Model model,@RequestParam("user") String user) {
//        返回借阅的书籍与借阅人信息
        Reader r=readerService.findByName(user);
        Integer r_id=r.getR_id();
        List<Map> borrowList= borrowMapper.findAllDetail(r_id);
        model.addAttribute("borrowList",borrowList);
        return "r_3";
    }
//   用户，个人中心
    @GetMapping("/user/Myuser")
    public String user5(Model model) {
        return "r_4";
    }




}
