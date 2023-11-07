package com.example.library.service.impl;

import com.example.library.mapper.BorrowMapper;
import com.example.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;
    @Override
    public void insertBorrow(Integer b_id, Integer r_id) {
        borrowMapper.insertBorrow(b_id,r_id);
    }
}
