package com.lanyu.getaway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

/**
 * Description: 动态路由查看
 *
 * @Author: 朱佳明
 * Date: 2019-02-22
 * Time: 9:12 PM
 */
@Component
public class ZuulConfig {


    @ConfigurationProperties("zuul")
    @RefreshScope
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }

}
