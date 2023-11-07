package com.example.library.mapper;

import com.example.library.domain.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {
    @Select("SELECT * FROM book ")
    public List<Book> queryAll();
    @Select("SELECT * FROM book where b_exit>0")
    public List<Book> findBook();
    @Select("select * from book where b_id= #{b_id}")
    public Book findById(Integer id);
    @Select("select * from book where b_name like #{b_name}")
    public List<Book> findByNames(String b_name);
    @Insert("insert into book(b_name,b_auther,b_other,b_exit,t_id)"+
            "values(#{b_name},#{b_auther},#{b_other},#{b_exit},#{t_id})")
    public int insertBook(Book book);
    @Delete("delete from book where b_id= #{b_id}")
    public void deleteBook(Integer b_id);
    @Update("update book set b_name=#{b_name},b_auther=#{b_auther},b_other=#{b_other},b_exit=#{b_exit} where b_id=#{b_id}")
    public int updateBook(Book book);
//    查询所有图书，并携带分类信息
//    @Select("select *from book")
//    @Results(id="bookMap",value = {
//            @Result(id = true,column = "b_id",property = "b_id"),
//            @Result(column = "b_name",property = "b_name"),
//            @Result(column = "b_auther",property = "b_auther"),
//            @Result(column = "b_other",property = "b_other"),
//            @Result(column = "b_exit",property = "b_exit"),
//            @Result(column = "t_id",property = "t_id"),
//            @Result(property = "sort",
//                    column = "tid",
//                    many = @Many(select = "com.example.library.mapper.findById"))
//
//    })
    //加入借阅表
//   查询出所有借阅信息
    @Select("select * from book b,reader r where " +
            "r.r_id=#{r_id} and b.b_id=#{b_id}")
    public List<Map> findAllBorrow(Integer b_id,Integer r_id);
   //查出所有图书信息携带分类信息
    @Select("select * from sort s,book b where s.tid=b.t_id")
    List<bookDTO> findAll();
//    查询出一名用户的全部书籍信息
    @Select("select * from sort s,book b where s.tid=b.t_id and b.b_id=#{b_id}")
    List<bookDTO> findbyId(Integer id);
    @Select("select * from b_id=#{id}")
    public Book findByid(Integer id);
}
