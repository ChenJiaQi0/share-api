package top.chen.share.common.exception;

import lombok.Getter;

/**
 * Author:CJQ
 * Date:2023/10/7
 */
@Getter
public class BusinessException extends RuntimeException{
    private BusinessExceptionEnum e;

    public BusinessException(BusinessExceptionEnum e) {
        this.e = e;
    }

    public void setE(BusinessExceptionEnum e) {
        this.e = e;
    }
}
