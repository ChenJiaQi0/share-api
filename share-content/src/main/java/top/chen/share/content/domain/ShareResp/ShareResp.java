package top.chen.share.content.domain.ShareResp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.chen.share.content.domain.entity.Share;

/**
 * Author:CJQ
 * Date:2023/10/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShareResp {
    /**
     * 分享内容对象
     */
    private Share share;
    /**
     * 发布者昵称
     */
    private String nickname;
    /**
     * 发布者头像
     */
    private String avatarUrl;
}
