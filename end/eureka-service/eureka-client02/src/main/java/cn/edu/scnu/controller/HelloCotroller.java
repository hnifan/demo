package cn.edu.scnu.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloCotroller {
    //@value注解，读取配置文件的属性
    @Value("${server.port}")
    private String port;
    @RequestMapping("hello")
    public String sayHello(String name) {
        return "hello " + name + ",i am from " + port;
    }
}
