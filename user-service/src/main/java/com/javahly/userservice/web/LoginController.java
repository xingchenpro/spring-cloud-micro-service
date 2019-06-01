package com.javahly.userservice.web;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2019/3/25
 */

@RestController
public class LoginController {

    /*必须POST请求，否则跳转到此页面*/
    @RequestMapping(value="/login_page")
    public String loginPage() {
       return "未登录!";
    }


}


