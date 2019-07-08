package com.wh.exception;


import com.wh.base.JsonData;
import com.wh.base.ResponseBase;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.ExecutionException;

/**
 * 异常处理控制器
 */
@RestControllerAdvice
public class LsExceptionHandler {

    /**
     * 自定义异常拦截
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseBase Handler(Exception e) {
        if (e instanceof LsException) {
            //自定义异常
            LsException lsException = (LsException) e;
            return JsonData.setResultError(lsException.getMsg());
        } else if (e instanceof ExecutionException) {
            return JsonData.setResultError("多线程数据处理中断" + e.getMessage());
        } else if (e instanceof NullPointerException) {
            return JsonData.setResultError("空指针异常,请检查参数" + e.getMessage());
        }
        String abbreviate = StringUtils.abbreviate(e.getMessage(), "...", 300);
//        System.out.println(e.getMessage());
        return JsonData.setResultError("全局异常，未知错误" + abbreviate);
    }
}
