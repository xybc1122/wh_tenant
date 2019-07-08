package com.wh.interceoter;


import com.wh.base.JsonData;
import com.wh.service.redis.RedisService;
import com.wh.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 监听器
 */
@Component
public class InterCenter implements HandlerInterceptor {
    /**
     * redis
     */
    @Autowired
    private RedisService redisService;

    private static InterCenter interCenter;

    //通过@PostConstruct实现初始化bean之前进行的操作
    @PostConstruct
    public void init() {
        interCenter = this;
    }



    /**
     * 用户登录进入controller层之前 进行拦截
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
//        String ip = IpUtils.getIpAddr(request);
//        //这里判断频繁请求 api  限制
//        if (!accessLimit(request, response, ip)) return false;

        return true;
    }

    private boolean accessLimit(HttpServletRequest request, HttpServletResponse response, String id) {
        // seconds是多少秒内可以访问多少次
        long seconds = 10;
        //5次
        int maxCount = 5;
        String key = request.getRequestURI();
        String tKey = key + "_" + id;
        //从redis中获取用户访问的次数
        String count = interCenter.redisService.getStringKey(tKey);
        if (count == null) {
            //第一次访问
            interCenter.redisService.setString(tKey, "1", seconds);
        } else if (Integer.parseInt(count) < maxCount) {
            //加1
            interCenter.redisService.setEx(tKey, 1);
        } else {
            //超出访问次数
            JsonUtils.sendJsonMsg(response, JsonData.setResultError(-1, "访问太频繁,请稍后在试"));
            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("afterCompletion");
    }

}
