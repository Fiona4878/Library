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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private ReaderService readerService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowMapper borrowMapper;
    @PostMapping("/book/add")
    public String book1(String b_name ,String b_auther,String b_other,String b_exit) {
        Book b=new Book();
        b.setB_name(b_name);
        b.setB_auther(b_auther);
        b.setB_other(b_other);
        b.setB_exit(Integer.valueOf(b_exit));
        bookService.save(b);
        return "redirect:/manager/back";
//        管理员 全部图书 添加
    }
    @PostMapping("/book/edit")
    public String reader1(String b_id,String b_name ,String b_auther,String b_other,String b_exit) {
        Book b=new Book();
        b.setB_id(Integer.valueOf(b_id));
        b.setB_name(b_name);
        b.setB_auther(b_auther);
        b.setB_other(b_other);
        b.setB_exit(Integer.valueOf(b_exit));
        System.out.println(b+"nn");
        bookService.edit(b);
        return "redirect:/manager/book";
    }
    @GetMapping("/book/delete")
    public String book1(@RequestParam("id") Integer id ) {
        bookService.delete(id);
        return "redirect:/manager/book";
        //        管理员 全部图书 删除

    }
    @GetMapping("/book/backs")
    public String book2(@RequestParam("bid") Integer bid,@RequestParam("id") Integer id ) {
        Book b=bookService.findById(bid);
        b.setB_exit(b.getB_exit()+1);
        bookService.edit(b);
        borrowMapper.deleteBorrow(id);
        return "redirect:/manager/back";
        //        管理员 全部图书 删除

    }
}
