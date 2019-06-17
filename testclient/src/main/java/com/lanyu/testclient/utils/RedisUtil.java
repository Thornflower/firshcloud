package com.lanyu.testclient.utils;

import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Description: 饿汉模式
 *
 * @Author: 朱佳明
 * Date: 2019-03-01
 * Time: 4:46 PM
 */
public class RedisUtil {


    private RedisUtil(){}

    private static StringRedisTemplate redisTemplate = new StringRedisTemplate();

    public static StringRedisTemplate getRedisTemplate(){
        return redisTemplate;
    }
}
