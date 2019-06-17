package com.lanyu.testclient.controller;

import com.lanyu.testclient.feignclient.FeignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: feign用法
 *
 * @Author: 朱佳明
 * Date: 2019-02-17
 * Time: 12:12 PM
 */

@RestController
public class FeignController {

    @Autowired
    private FeignMapper feignMapper;


    @GetMapping("/getClientMsg")
    public String getMsg(){
        String response = feignMapper.getMsg();
        System.out.println(response);
        return response;
    }

}
