package com.lanyu.testclient.controller;

import com.lanyu.testclient.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description: restTemplate 三种用法
 *
 * @Author: 朱佳明
 * Date: 2019-01-16
 * Time: 2:44 PM
 */
@RestController
public class DetailController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getOrderMsg")
    public String getOrderMsg(){
        //1.第一种方式
        /*RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8763/msg",String.class);*/

        //2.第二种方式(通过应用名获取url)
        /*RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("client");
        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/msg";
        String response = restTemplate.getForObject(url,String.class);*/

        //3.第三种方式
        String response = restTemplate.getForObject("http:// /msg",String.class);

        return response;
    }
}
