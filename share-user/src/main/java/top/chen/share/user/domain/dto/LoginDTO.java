package top.chen.share.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:CJQ
 * Date:2023/10/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDTO {
    private String phone;
    private String password;
}
