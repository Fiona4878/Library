package com.example.library.service;

import com.example.library.domain.Manager;
import com.example.library.domain.Reader;

import java.util.List;

public interface ReaderService {
    //    查询所有用户
    public List<Reader> queryAll();
    //    用户名查询所有
    public Reader findByName(String name);
    public List<Reader> findByNames(String name);
    public void save(Reader reader);
    public void delete(Integer id);
    public void edit(Reader reader);
    public boolean isTure(String name,String pwd);
}
