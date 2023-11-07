package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.domain.Manager;

import java.util.List;

public interface ManagerService {
    public List<Manager> findAll();
    public Manager findByName(String name);
    public List<Manager> findByNames(String name);
    public void save(Manager manager);
    public void delete(Integer id);
    public boolean isTure(String name,String pwd);
}
