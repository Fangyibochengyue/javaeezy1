package com.sias.dao;

import com.sias.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from students ")
    List<Student> selectAll();

    @Delete("delete from students where stuNO=#{id}")
    void deleteById(int id);
    @Select("select * from students where stuNO=#{id}")
    Student selectByID(int id);

    @Update("update students set name=#{name},sex=#{sex},nation=#{nation},telephone=#{telephone},birthday=#{birthday},address=#{address},photo=#{photo},resume=#{resume} where stuNO=#{stuNO}")
    void updateByID(Student student);

    @Insert("insert into students(name,sex,nation,telephone,birthday,address,photo,resume) values (#{name},#{sex},#{nation},#{telephone},#{birthday},#{address},#{photo},#{resume})")
    void insertI(Student student);

    @Select("select count(*) from students where name=#{name}")
    int selectBYY(String name);
}
