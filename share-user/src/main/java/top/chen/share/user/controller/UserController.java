package top.chen.share.user.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.chen.share.user.domain.dto.LoginDTO;
import top.chen.share.user.domain.entity.User;
import top.chen.share.user.service.UserService;

/**
 * Author:CJQ
 * Date:2023/10/7
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/count")
    public Long count(){
        return userService.count();
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDTO loginDTO){
        return userService.login(loginDTO);
    }
}
