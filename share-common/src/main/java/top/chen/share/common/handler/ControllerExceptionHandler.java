package top.chen.share.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.chen.share.common.exception.BusinessException;
import top.chen.share.common.resp.CommonResp;
import org.springframework.validation.BindException;

/**
 * Author:CJQ
 * Date:2023/10/7
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResp<?> exceptionHandler(Exception e) throws Exception{
        CommonResp<?> resp = new CommonResp<>();
        log.error("系统异常", e);
        resp.setSuccess(false);
        resp.setMessage(e.getMessage());
        return resp;
    }

    /**
     * 业务异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResp<?> exceptionHandler(BusinessException e){
        CommonResp<?> resp = new CommonResp<>();
        log.error("业务异常", e);
        resp.setSuccess(false);
        resp.setMessage(e.getE().getDesc());
        return resp;
    }

    /**
     * 数据校验统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResp<?> exceptionHandler(BindException e){
        CommonResp<?> resp = new CommonResp<>();
        log.error("校验异常", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        resp.setSuccess(false);
        resp.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return resp;
    }
}
