package com.wh.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * @ClassName WrapperUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/10 15:03
 **/
public class WrapperUtils {


    /**
     * 封装获得 普通条件表达式
     *
     * @return
     */
    public static <T> QueryWrapper<T> getQuery() {
        return Wrappers.query();
    }

    /**
     * 封装获得 lambda表达式
     *
     * @return
     */
    public static <T> LambdaQueryWrapper<T> getLambdaQuery() {
        return Wrappers.lambdaQuery();
    }

}
