package com.javahly.articleservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ArticleServiceApplication {

    //http://localhost:8763/actuator/bus-refresh
    @Value("${creator}")
    String creator;

    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApplication.class, args);
    }

    @RequestMapping(value = "/hi")
    public String hi(){
        return creator;
    }
}
