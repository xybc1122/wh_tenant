package com.wh.customize;

/**
 * @ClassName RedisLock
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/26 14:29
 * redis分布式锁注解
 **/

import java.lang.annotation.*;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RedisLock {

    /**
     * 锁的key
     *
     * @return 锁的key
     */
    String key();

    /**
     * 最大等待时间 毫秒
     *
     * @return 最大等待时间毫秒
     */
    long maxWait();

    /**
     * 锁最大占用时间秒
     *
     * @return 锁最大占用时间秒
     */
    long timeout();
}
