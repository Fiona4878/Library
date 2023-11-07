package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.domain.Manager;

import java.util.List;

public interface BookService {
    public List<Book> findAll();
    public List<Book> findByNames(String name);
    public void save(Book book);
    public void delete(Integer id);
    public Book findById(Integer id);
    public void edit(Book book);
}
