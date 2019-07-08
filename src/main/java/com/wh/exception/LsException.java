package com.wh.exception;

/**
 * 继承运行时异常
 */
public class LsException extends RuntimeException {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 异常消息
     */
    private String msg;


    public LsException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public LsException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
