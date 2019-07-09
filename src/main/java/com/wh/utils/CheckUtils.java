package com.wh.utils;

import com.wh.exception.LsException;

/**
 * @ClassName CheckUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/14 15:44
 **/
public class CheckUtils {
    /**
     * 如果新增失败直接报错
     *
     * @param result
     * @return
     */
    public static void saveResult(boolean result) {
        if (!result) {
            throw new LsException("save error");
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
            throw new LsException("save error");
        }
    }

}
