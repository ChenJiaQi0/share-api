package top.chen.share.user.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Author:CJQ
 * Date:2023/10/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String phone;
    private String password;
    private String nickname;
    private String roles;
    private String avatarUrl;
    private Integer bonus;
    private Date createTime;
    private Date updateTime;
}
