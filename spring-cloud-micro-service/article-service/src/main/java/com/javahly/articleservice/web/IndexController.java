package com.javahly.articleservice.web;

import com.javahly.articleservice.entity.Articles;
import com.javahly.articleservice.mapper.IndexMapper;
import com.javahly.articleservice.util.RedisUtil;
import com.javahly.articleservice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.rmi.CORBA.Util;
import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/8/10
 * @QQ :1136513099
 * @desc :
 */
@RestController
@RefreshScope
public class IndexController {
  /*  @Value("${creator}")
    String creator;

    @RequestMapping(value = "/hi")
    public String hi() {
        return creator;
    }*/
    @Autowired
    RedisUtil redis;

    @Autowired
    IndexMapper indexMapper;

    @RequestMapping(value = "/articles")
    public Result getArticles(){
        Result result = new Result();
        List<Articles> articles =null;
        if(redis.hasKey("articles")){
          result.setResult(redis.lGet("articles",0,-1));
        }else{
            articles =indexMapper.getArticles();
            redis.lSet("articles",articles);
            result.setResult(articles);
        }
        System.out.println(articles);
        return result;
    }

    @RequestMapping(value = "/article")
    public Result addUser() {
        Result result = new Result();
        int addResult = indexMapper.addArticle();
        result.setResult(addResult);
        return result;
    }
}
