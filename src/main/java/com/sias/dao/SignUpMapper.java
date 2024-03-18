package com.sias.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SignUpMapper {

    @Select("select count(*) from table_name where username=#{username}")
    int slectByName(String username);
    @Insert("insert into table_name(username,password,tel,email) values (#{username},#{password},#{tel},#{email})")
    void InsertUU(String username, String password,String tel,String email);
}
