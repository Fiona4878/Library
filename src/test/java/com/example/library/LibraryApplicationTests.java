package com.example.library;

import com.example.library.domain.Manager;
import com.example.library.domain.Reader;
import com.example.library.domain.Sort;
import com.example.library.domain.bookDTO;
import com.example.library.mapper.BookMapper;
import com.example.library.mapper.ReaderMapper;
import com.example.library.service.ReaderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class LibraryApplicationTests {
    @Autowired
    private ReaderService readerService;
    @Autowired
    private BookMapper bookMapper;
    @Test
    public void selectReader() {
        Reader r=readerService.findByName("root");
        Integer r_id=r.getR_id();
        System.out.println(r_id+"11");
    }




    @Test
    void contextLoads() {
        System.out.println("start");
    }

}
