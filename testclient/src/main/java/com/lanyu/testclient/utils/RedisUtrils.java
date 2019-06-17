package com.lanyu.testclient.utils;

import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Description:懒汉式
 *
 * @Author: 朱佳明
 * Date: 2019-03-01
 * Time: 4:53 PM
 */
public class RedisUtrils {


    private RedisUtrils(){}

    private static StringRedisTemplate redisTemplate;

    public static StringRedisTemplate getRedisTemplate(){
        if(redisTemplate==null){
            redisTemplate = new StringRedisTemplate();
        }

        return redisTemplate;
    }
}
