package com.javahly.articleservice.mapper;

import com.javahly.articleservice.entity.Articles;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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

    @Select("select * from articles")
    public List<Articles> getArticles();

    @Insert("insert into articles(name,content) values('sss','sss')")
    public int addArticle();

}
