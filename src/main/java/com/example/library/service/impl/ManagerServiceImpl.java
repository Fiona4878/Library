package com.example.library.service.impl;

import com.example.library.domain.Manager;
import com.example.library.mapper.ManagerMapper;
import com.example.library.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public List<Manager> findAll() {
        return managerMapper.queryAll();
    }

    @Override
    public Manager findByName(String name) {
        return managerMapper.findByName(name);
    }

    @Override
    public List<Manager> findByNames(String name) {
        return managerMapper.findByNames(name);
    }

    @Override
    public void save(Manager manager) {
        managerMapper.insertManager(manager);
    }

    @Override
    public void delete(Integer id) {
        managerMapper.deleteManager(id);
    }

    @Override
    public boolean isTure(String name, String pwd) {
       Manager m= managerMapper.findByName(name);
       System.out.println(m);
       if(m==null || !m.getM_pw().equals(pwd)){
           return false;
       }
        return true;
    }
}
