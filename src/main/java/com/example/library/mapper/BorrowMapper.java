package com.example.library.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BorrowMapper {
    @Insert("insert into borrow(b_id,r_id)"+
            "values(#{b_id},#{r_id})")
    public void insertBorrow(Integer b_id,Integer r_id);

    @Select("select * from book b,borrow bo,reader r where bo.b_id=b.b_id and bo.r_id=r.r_id and r.r_id=#{r_id}")
    public List<Map> findAllDetail(Integer r_id);
    @Select("select * from book b,borrow bo,reader r where bo.b_id=b.b_id and bo.r_id=r.r_id")
    public List<Map> findAll();
    @Delete("delete from borrow where id= #{id}")
    public void deleteBorrow(Integer id);
}
