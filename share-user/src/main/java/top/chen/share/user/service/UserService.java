package top.chen.share.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.chen.share.common.exception.BusinessException;
import top.chen.share.common.exception.BusinessExceptionEnum;
import top.chen.share.user.domain.dto.LoginDTO;
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

    public User login(LoginDTO loginDTO) {
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
        return userDB;
    }
}
