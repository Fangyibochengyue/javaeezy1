package com.sias.dao;
import com.sias.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface LoginMapper {
    @Select("select count(*) from table_name where username=#{username} and password=#{password}")
    int login(User user);
}
