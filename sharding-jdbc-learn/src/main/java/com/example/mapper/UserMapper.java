package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    @Insert("insert into user (username, password, age) values (#{user.username}, #{user.password}, #{user.age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer addUser(@Param("user") User user);
}
