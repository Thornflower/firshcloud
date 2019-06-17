package com.lanyu.testclient.service;

import com.lanyu.testclient.utils.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author: 朱佳明
 * Date: 2019-03-01
 * Time: 4:46 PM
 */

@Component
public class RedisLock {



    /**
    *
    * 功能描述： 加锁
    *
    * @param    key   productId
    * @param    value  当前时间+超时时间
    * @return
    * @author zjm
    * @date 2019/3/1 4:56 PM
    */
    public boolean lock(String key , String value){
        if(RedisUtil.getRedisTemplate().opsForValue().setIfAbsent(key, value)){
            return true;
        }

        String currentValue = RedisUtil.getRedisTemplate().opsForValue().get(key);
        //如果锁过期
        if(!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue) < System.currentTimeMillis()){
            //获取上个锁的时间
            String oldValue = RedisUtil.getRedisTemplate().opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
        }

        return false;
    }


    /**
    *
    * 功能描述：解锁
    *
    * @param
    * @return
    * @author zjm
    * @date 2019/3/1 5:18 PM
    */
    public void unlock(String key, String value){
        try{
            String currentValue = RedisUtil.getRedisTemplate().opsForValue().get(key);
            if(!StringUtils.isEmpty(currentValue) && currentValue.equals(value)){
                RedisUtil.getRedisTemplate().opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            System.out.println("解锁异常");
            e.printStackTrace();
        }

    }
}
