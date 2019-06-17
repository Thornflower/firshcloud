package com.lanyu.testclient.controller;

import com.lanyu.testclient.feignclient.FeignMapper;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:     豪猪测
 *
 * @Author: 朱佳明
 * Date: 2019-03-13
 * Time: 10:18 AM
 */
@RestController
//@DefaultProperties(defaultFallback = "defaultFallback")//默认服务降级
public class HystrixController {


    @Autowired
    private FeignMapper feignMapper;

    private static int MAGIC = 2;



//    @HystrixCommand(fallbackMethod = "fallback") //服务降级

//    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
//            //设置熔断
//            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
//            //该属性用来设置在滚动时间窗中，断路器的最小请求数。例如：默认值 20 的情况下，如果滚动时间窗（默认值 10秒）内仅收到19个请求，即使这19个请求都失败了，断路器也不会打开
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
//            //该属性用来设置当断路器打开之后的休眠时间窗。默认值 5000 毫秒，休眠时间窗结束之后，会将断路器设置为"半开"状态，尝试熔断的请求命令，如果依然失败就将断路器继续设置为"打开"状态，如果成功就设置为"关闭"状态。
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//            //该属性用来设置断路器打开的错误百分比条件 默认50
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
//    })
//    @HystrixCommand  //如果使用配置   必须加注解才可以生效
    @HystrixCommand(fallbackMethod = "fallback" , commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" , value = "3000") //设置超时时间为3秒  默认为1秒
    })
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number") Integer number){
        //测试 服务熔断 如果偶数 直接通过  奇数 则熔断        下面的feign接口有设置超时2秒
        if (number % MAGIC == 0){
            return "success";
        }
        String response = feignMapper.getList("123456");
        System.out.println(response);
        return response;
    }


    private String fallback(Integer number){
        return "太拥挤了 , 请稍后重试";
    }


    private String defaultFallback(){
        return "默认降级 太拥挤了 , 请稍后重试";
    }
}
