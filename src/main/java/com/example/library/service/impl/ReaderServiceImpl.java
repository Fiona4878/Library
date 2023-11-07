package com.example.library.service.impl;

import com.example.library.domain.Reader;
import com.example.library.mapper.ReaderMapper;
import com.example.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    ReaderMapper readerMapper;
    @Override
    public List<Reader> queryAll() {
        return readerMapper.queryAll();
    }

    @Override
    public Reader findByName(String name) {
        return readerMapper.queryAllByName(name);
    }

    @Override
    public List<Reader> findByNames(String name) {
        return readerMapper.findByNames(name);
    }

    @Override
    public void save(Reader reader) {
        readerMapper.insertReader(reader);
    }

    @Override
    public void delete(Integer id) {
        readerMapper.deleteReader(id);
    }

    @Override
    public void edit(Reader reader) {
        readerMapper.updateReader(reader);
    }

    @Override
    public boolean isTure(String name, String pwd) {
        Reader r =readerMapper.queryAllByName(name);
        if(r==null || !r.getR_pw().equals(pwd)){
            return false;
        }
        return true;
    }
}
