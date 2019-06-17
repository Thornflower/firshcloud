package com.lanyu.testclient.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description:
 *
 * @Author: 朱佳明
 * Date: 2019-02-17
 * Time: 12:08 PM
 */
@Component
@FeignClient(name="client")
public interface FeignMapper {

    /**
    *
    * 功能描述：获取client的接口信息
    *
    * @param
    * @return
    * @author zjm
    * @date 2019/2/17 12:11 PM
    */
    @GetMapping("/msg")
    String getMsg();

    
    /**
    *
    * 功能描述：
    *
    * @param msg
    * @return 
    * @author zjm
    * @date 2019/3/13 11:02 AM
    */
    @GetMapping("/getList")
    String getList(@RequestParam("msg") String msg);
    

}
