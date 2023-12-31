package top.chen.share.content.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:CJQ
 * Date:2023/10/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MidUserShare {
    private Long id;
    private Long shareId;
    private Long userId;
}
