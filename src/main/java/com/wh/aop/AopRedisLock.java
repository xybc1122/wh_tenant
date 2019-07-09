package com.wh.aop;

import com.wh.customize.RedisLock;
import com.wh.exception.LsException;
import com.wh.service.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName AopRedisLock
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/26 14:27
 **/
@Aspect
@Component
@Order(2)
public class AopRedisLock {
    /**
     * 日志记录
     */
//    private final static Logger LOG = LoggerFactory.getLogger(AopRedisLock.class);

    @Autowired
    private RedisService redisService;

    @Pointcut("@annotation(com.wh.customize.RedisLock)")
    public void addLockAnnotationPointcut() {
    }


    @Around(value = "addLockAnnotationPointcut()")
    public Object addKeyMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        //定义返回值
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        RedisLock annotation = AnnotationUtils.findAnnotation(targetMethod, RedisLock.class);
        if (annotation != null) {
            //前置方法 开始
            String identifier = null;
            try {
                //true代表成功了，false代表加锁失败
                identifier = redisService.lockRedis(annotation.key(), annotation.maxWait(), annotation.timeout());
                // 目标方法执行
                if (StringUtils.isNotBlank(identifier)) {
                    return joinPoint.proceed();
                }
                throw new LsException("请稍等");
            } finally {
                if (StringUtils.isNotBlank(identifier)) {
                    redisService.releaseLock(annotation.key(), identifier);
                }
            }
        }
        throw new LsException("注解无参数,联系程序员");
    }

}
