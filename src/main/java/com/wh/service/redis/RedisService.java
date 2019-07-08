package com.wh.service.redis;


import com.wh.exception.LsException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;




    /**
     * 定义成功一个方法调用
     *
     * @return
     */
    public ValueOperations<String, String> ForValue() {
        return stringRedisTemplate.opsForValue();
    }

    // String方法无time
    public boolean setString(String key, Object value) {
        return setObject(key, value, null);
    }

    // String方法有time
    public boolean setString(String key, Object value, Long time) {
        return setObject(key, value, time);
    }

    // List方法
    public void setList(String key, Object value) {
        this.setObject(key, value, null);
    }

    private boolean setObject(String key, Object value, Long time) {
        try {
            // redis几张有效期限 string list set zset hash
            if (StringUtils.isEmpty(key) || value == null) {
                throw new LsException("存入失败");
            }
            // 判断类型 存放string
            if (value instanceof String) {
                String strValue = (String) value;
                if (time != null) {
                    stringRedisTemplate.opsForValue().set(key, strValue, time, TimeUnit.SECONDS);// 存入模板
                    return true;
                } else {
                    stringRedisTemplate.opsForValue().set(key, strValue);    // 存入模板
                    return true;
                }
            }
            // 存放list类型
            if (value instanceof List) {
                List<Object> listValue = (List<Object>) value;
                stringRedisTemplate.opsForList().leftPush(key, listValue.toString());
                return true;
            }
        } catch (Exception e) {
            throw new LsException("存入失败");
        }
        throw new LsException("存入失败");
    }

    /**
     * 设置 nx
     *
     * @param key
     * @return
     */
    public void setEx(String key, Integer value) {
        if (key != null) {
            stringRedisTemplate.boundValueOps(key).increment(value);
        }
    }

    /**
     * 取String
     *
     * @param key
     * @return
     */
    public String getStringKey(String key) {
        if (key != null) {
            return this.ForValue().get(key);
        }
        return null;
    }


    public StringRedisTemplate stringRedisTemplate() {
        return stringRedisTemplate;
    }


    /**
     * 取keys
     *
     * @param key
     * @return
     */
    public Boolean setNx(String key, String value) {
        if (key != null) {
            return stringRedisTemplate.opsForValue().setIfAbsent(key, value);
        }
        return false;
    }

    /**
     * 取keys
     *
     * @param key
     * @return
     */
    public Set getKeys(String key) {
        if (key != null) {
            return stringRedisTemplate.keys(key + "*");
        }
        return null;
    }

    public String getListKey(String key) {
        if (key != null) {
            String leftPop = stringRedisTemplate.opsForList().leftPop(key);
            return leftPop;
        }
        return null;
    }

    //获取key 过期时间
    public Long getTtl(String key) {
        return stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    //redis 删除当前库的所有数据
    public void delKeyAll(String key) {
        Set<String> keys = stringRedisTemplate.keys(key + "*");
        if (keys != null) {
            stringRedisTemplate.delete(keys);
        }
    }

    //redis 统计数据 在线人数数据
    public int userCount() {
        Set<String> keys = stringRedisTemplate.keys("*");
        if (keys != null && keys.size() > 0) {
            return keys.size();
        }
        return 0;
    }

    //redis 删除数据
    public Boolean delKey(String key) {
        try {
            if (key != null) {
                return stringRedisTemplate.delete(key);
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
