package top.chen.share.user.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.chen.share.common.exception.BusinessException;
import top.chen.share.common.exception.BusinessExceptionEnum;
import top.chen.share.common.util.JwtUtil;
import top.chen.share.common.util.SnowUtil;
import top.chen.share.user.domain.dto.LoginDTO;
import top.chen.share.user.domain.entity.User;
import top.chen.share.user.domain.resp.UserLoginResp;
import top.chen.share.user.mapper.UserMapper;

import java.util.Date;
import java.util.Map;

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

    public User findById(Long userId) {
        return userMapper.selectById(userId);
    }

    public UserLoginResp login(LoginDTO loginDTO) {
        //根据手机号查询用户
        User userDB = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getPhone, loginDTO.getPhone()));
        //没找到，抛出运行时异常
        if (userDB == null) {
            throw new BusinessException(BusinessExceptionEnum.PHONE_NOT_EXIST);
        }
        //密码错误
        if (!userDB.getPassword().equals(loginDTO.getPassword())) {
            throw new BusinessException(BusinessExceptionEnum.PASSWORD_ERROR);
        }
        //都正确，返回
        UserLoginResp userLoginResp = UserLoginResp.builder()
                .user(userDB)
                .build();
//        String key = "ccen";
//        Map<String, Object> map = BeanUtil.beanToMap(userLoginResp);
//        String token = JWTUtil.createToken(map, key.getBytes());
        String token = JwtUtil.createToken(userLoginResp.getUser().getId(), userLoginResp.getUser().getPhone());
        userLoginResp.setToken(token);
        return userLoginResp;
    }

    public Long register(LoginDTO loginDTO){
        //根据手机号查询用户
        User userDB = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getPhone, loginDTO.getPhone()));
        //找到了，手机号已被注册
        if (userDB != null) {
            throw new BusinessException(BusinessExceptionEnum.PHONE_EXIST);
        }
        User savedUser = User.builder()
                //使用雪花算法生成 id
                .id(SnowUtil.getSnowflakeNextId())
                .phone(loginDTO.getPhone())
                .password(loginDTO.getPassword())
                .nickname("新用户")
                .roles("user")
                .avatarUrl("https://i2.100024.xyz/2023/01/26/3e727b.webp")
                .bonus(100)
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        userMapper.insert(savedUser);
        return savedUser.getId();
    }
}
