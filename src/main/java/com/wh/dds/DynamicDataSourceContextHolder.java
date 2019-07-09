package com.wh.dds;

import com.wh.exception.LsException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 动态数据源上下文
 *
 * @author Louis
 * @date Oct 31, 2018
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>() {
        /**
         * 将 the-host 数据源的 key作为默认数据源的 key
         */
        @Override
        protected String initialValue() {
            return "master";
        }
    };


    /**
     * 数据源的 key集合，用于切换时判断数据源是否存在
     */
    private static List<Object> dataSourceKeys = new ArrayList<>();

    /**
     * 切换数据源
     *
     * @param key
     */
    public static void setDataSourceKey(String key) {
        //如果不是null 切换
        if (containDataSourceKey(key)) {
            contextHolder.set(key);
            return;
        }
        throw new LsException("预先加载没有此租户标识");
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static String getDataSourceKey() {
        return contextHolder.get();
    }

    /**
     * 重置数据源
     */
    public static void clearDataSourceKey() {
        contextHolder.remove();
    }

    /**
     * 判断是否包含数据源
     *
     * @param key 数据源key
     * @return
     */
    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }

    /**
     * 添加数据源keys
     *
     * @param keys
     * @return
     */
    public static boolean addDataSourceKeys(Collection<? extends Object> keys) {

        return dataSourceKeys.addAll(keys);
    }
}
