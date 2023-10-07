package top.chen.share.user.domain.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.chen.share.user.domain.entity.User;

/**
 * Author:CJQ
 * Date:2023/10/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginResp {
    private User user;
    private String token;
}
