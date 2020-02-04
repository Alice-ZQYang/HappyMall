package com.miaoshaproject;

import com.miaoshaproject.dao.UserDOMapper;
import com.miaoshaproject.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
// 将app的启动类当成一个自动化可以启动的bin，并能够开启整个project的基于springboot的一个自动化配置
    // 启动内嵌的tomcat容器 @EnableAutoConfiguration === @SpringBootApplication

@RestController
@SpringBootApplication(scanBasePackages = {"com.miaoshaproject"})
@MapperScan("com.miaoshaproject.dao")
public class App 
{
    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String home(){
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if (userDO == null){
            return "object not found";
        }
        else {
            return userDO.getName();
        }

    }

    public static void main( String[] args )
    {
        System.out.println("Hello World!");
        SpringApplication.run(App.class, args);
    }
}
