package com.javahly.userservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Value("${creator}")
    String creator;

    @RequestMapping(value = "/hi")
    public String hi() {
        return creator;
    }
}
