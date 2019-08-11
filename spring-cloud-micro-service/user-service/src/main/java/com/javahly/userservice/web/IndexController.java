package com.javahly.userservice.web;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.javahly.userservice.entity.User;
import com.javahly.userservice.mapper.IndexMapper;
import com.javahly.userservice.util.RedisUtil;
import com.javahly.userservice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/users")
    public Result getUsers() {
        Result result = new Result();
        List<User> articles = null;
        if (redis.hasKey("users")) {
            result.setResult(redis.lGet("users", 0, -1));
        } else {
            articles = indexMapper.getUsers();
            redis.lSet("users", articles);
            result.setResult(articles);
        }
        System.out.println(articles);
        return result;
    }

    @RequestMapping(value = "/user")
    @Transactional
    @LcnTransaction //分布式事务注解
    public Result addUser() {
        Result result = new Result();
        int addResult = indexMapper.addUsers();
        result.setResult(addResult);
        return result;
    }
}
