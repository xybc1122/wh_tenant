package com.wh.base;
import com.wh.toos.Constants;
import org.springframework.stereotype.Component;


@Component
public class JsonData {

    // 返回错误 ，可以传msg
    public static ResponseBase setResultError(String msg) {
        return setResult(Constants.HTTP_RES_CODE, msg, null);
    }

    // 返回错误 ，传msg 跟data
    public static ResponseBase setResultError(String msg, Object data) {
        return setResult(Constants.HTTP_RES_CODE, msg, data);
    }


    // 返回错误 ，可以传msg 跟Code
    public static ResponseBase setResultError(Integer code, String msg) {
        return setResult(code, msg);
    }

    // 返回成功 ，只能传data值
    public static ResponseBase setResultSuccess(Object data) {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
    }

    // 返回成功 参数空
    public static ResponseBase setResultSuccess() {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, null);
    }

    // 返回成功 ，可以传msg
    public static ResponseBase setResultSuccess(String msg) {
        return setResult(Constants.HTTP_RES_CODE_200, msg, null);
    }

    // 返回成功 ，可以传msg ,data
    public static ResponseBase setResultSuccess(String msg, Object data) {
        return setResult(Constants.HTTP_RES_CODE_200, msg, data);
    }

    // 返回成功 ，可以传msg ,type
    public static ResponseBase setResultTypeSuccess(String msg, String type) {
        return setResultType(Constants.HTTP_RES_CODE_200, msg, type);
    }

    // 返回错误 ，可以传msg,type
    public static ResponseBase setResultTypeError(String msg, String type) {
        return setResultType(Constants.HTTP_RES_CODE, msg, type);
    }

    // 通用封装 code ,msg ,data
    private static ResponseBase setResult(Integer code, String msg, Object data) {
        return new ResponseBase(code, msg, data);
    }

    // 通用封装 code ,msg ,type
    private static ResponseBase setResultType(Integer code, String msg, String type) {
        return new ResponseBase(code, msg, type);
    }

    // 通用封装 code,msg
    private static ResponseBase setResult(Integer code, String msg) {
        return new ResponseBase(code, msg);
    }


}
