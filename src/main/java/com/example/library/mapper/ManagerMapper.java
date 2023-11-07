package com.example.library.mapper;

import com.example.library.domain.Book;
import com.example.library.domain.Manager;
import com.example.library.domain.Reader;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ManagerMapper {
    @Select("select * from manager where m_name=#{m_name}")
    public Manager findByName(String m_name);
    @Select("select * from manager where m_name like #{m_name}")
    public List<Manager> findByNames(String m_name);
    @Select("SELECT * FROM manager")
    public List<Manager> queryAll();
    @Delete("delete from manager where m_id= #{m_id}")
    public void deleteManager(Integer m_id);
    @Update("update manager set m_name=#{m_name},m_pw=#{m_pw} where m_id=#{m_id}")
    public int updateManager(Manager manager);
    @Insert("insert into manager(m_name,m_pw)"+
            "values(#{m_name},#{m_pw})")
    public int insertManager(Manager manager);
}
