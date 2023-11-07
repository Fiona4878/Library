package com.example.library.service.impl;

import com.example.library.domain.Book;
import com.example.library.mapper.BookMapper;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> findAll() {
        return bookMapper.queryAll();
    }
    @Override
    public List<Book> findByNames(String name) {
        return bookMapper.findByNames(name);
    }

    @Override
    public void save(Book book) {
        bookMapper.insertBook(book);
    }

    @Override
    public void delete(Integer id) {
        bookMapper.deleteBook(id);
    }

    @Override
    public Book findById(Integer id) {
        return bookMapper.findById(id);
    }

    @Override
    public void edit(Book book) {
        bookMapper.updateBook(book);
    }


}
