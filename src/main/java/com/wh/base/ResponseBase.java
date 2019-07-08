package com.wh.base;

/**
 * 封装返回前端
 */
public class ResponseBase {

    private Integer code;
    private String msg;
    private Object data;


    @Override
    public String toString() {
        return "ResponseBase [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

    public ResponseBase(Integer code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseBase(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResponseBase() {

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
