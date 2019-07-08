package com.wh.service.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ClassName feignClient
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/25 10:33
 **/

//然后再自己控制器里面调用此接口就完成了
@FeignClient(name = "java", url = "sss")
public interface feignClient {


}
