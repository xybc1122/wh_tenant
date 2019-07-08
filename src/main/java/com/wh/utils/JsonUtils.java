package com.wh.utils;

import com.google.gson.Gson;
import com.wh.exception.LsException;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName JsonUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/28 13:40
 **/
public class JsonUtils {

    private static Gson gson = new Gson();

    /**
     * 如果新增失败直接报错
     *
     * @param result
     * @return
     */
    public static void saveResult(boolean result) {
        if (!result) {
            throw new LsException("error");
        }
    }

    /**
     * 如果新增失败直接报错
     *
     * @param result
     * @return
     */
    public static void saveResult(int result) {
        if (result == 0) {
            throw new LsException("error");
        }
    }

    /**
     * 响应数据给前端
     *
     * @param response
     */
    public static void sendJsonMsg(HttpServletResponse response, Object obj) {
        try {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(gson.toJson(obj));
            writer.close();
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
