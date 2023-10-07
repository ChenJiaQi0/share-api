package top.chen.share.user.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.chen.share.user.domain.entity.User;
import top.chen.share.user.mapper.UserMapper;

/**
 * Author:CJQ
 * Date:2023/10/7
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public Long count(){
        return userMapper.selectCount(null);
    }
}
