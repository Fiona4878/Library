package com.example.library.mapper;

import com.example.library.domain.Reader;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ReaderMapper {
    @Select("SELECT * FROM reader")
    public List<Reader> queryAll();
    @Select("SELECT * FROM reader where r_name=#{r_name}")
    public Reader queryAllByName(String r_name);
    @Select("SELECT * FROM reader where r_name like #{r_name}")
    public List<Reader> findByNames(String r_name);
    @Select("SELECT * FROM reader where r_id=#{r_id}")
    public Reader findById(Integer r_id);
    @Insert("insert into reader(r_name,r_sex,r_phone,r_pw)"+
    "values(#{r_name},#{r_sex},#{r_phone},#{r_pw})")
    public int insertReader(Reader reader);
    @Update("update reader set r_name=#{r_name},r_sex=#{r_sex},r_phone=#{r_phone},r_pw=#{r_pw} where r_id=#{r_id}")
    public int updateReader(Reader reader);
    @Delete("delete from reader where r_id=#{r_id}")
    public int deleteReader(Integer r_id);
}
