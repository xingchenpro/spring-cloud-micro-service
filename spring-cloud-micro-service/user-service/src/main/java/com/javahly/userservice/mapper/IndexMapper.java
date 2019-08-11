package com.javahly.userservice.mapper;

import com.javahly.userservice.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/8/11
 * @QQ :1136513099
 * @desc :
 */
@Repository
public interface IndexMapper {

    @Select("select * from user")
    public List<User> getUsers();

    @Insert("insert into user(username,password) values(123,123)")
    //@Options(keyProperty="id",keyColumn="id",useGeneratedKeys=true)
    public int addUsers();

}
