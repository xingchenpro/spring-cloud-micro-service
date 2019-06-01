package com.javahly.userservice;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.javahly.userservice.dao")
@EnableCaching//开启全局缓存
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)//开启session共享，session有效期30分钟
@EnableSwagger2Doc
public class UserServiceApplication {

    //http://localhost:8762/swagger-ui.html
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
