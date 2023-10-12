package top.chen.share.content.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.chen.share.common.resp.CommonResp;

/**
 * Author:CJQ
 * Date:2023/10/12
 */
@FeignClient(value = "user-service", path = "/user")
public interface UserService {
    /**
     * 调用用户中心查询用户信息接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResp<User> getUser(@PathVariable Long id);
}
