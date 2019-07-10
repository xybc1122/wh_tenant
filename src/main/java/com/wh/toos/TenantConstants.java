package com.wh.toos;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName TenantConstants
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/7/9 17:35
 **/
public class TenantConstants {


    /**
     * 保存租户map对象
     */
    public static Map<Object, Object> dataSourceMap = new ConcurrentHashMap<>();
}
