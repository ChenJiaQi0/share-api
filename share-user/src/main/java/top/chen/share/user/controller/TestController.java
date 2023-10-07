package top.chen.share.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:CJQ
 * Date:2023/10/7
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(){
        int a = 1 / 0;
        return "hello world";
    }
}
