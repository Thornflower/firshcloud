package com.lanyu.testclient.service.impl;

import com.lanyu.testclient.service.LockService;
import com.lanyu.testclient.service.RedisLock;
import com.lanyu.testclient.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: redis加锁
 *
 * @Author: 朱佳明
 * Date: 2019-03-01
 * Time: 3:55 PM
 */
@Service
public class LockServiceImpl implements LockService {

    //超时时间十秒
    private static final int TIMEOUT = 10 * 1000;

    @Autowired
    private RedisLock redisLock;

    static Map<String,Integer> products;

    static Map<String,Integer> stock;

    static Map<String,String> orders;

    static {
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();


        products.put("123456", 100000);
        stock.put("123456", 100000);
    }

    private String queryMap(String productId){
        return "国庆活动，限量份"
                +products.get(productId)
                +"还剩"+stock.get(productId)+"份"
                +"该商品成功下单用户数目"
                +orders.size()+"人";
    }

    @Override
    public void addLock(String productId)   {


        //加锁
        long time = System.currentTimeMillis()+TIMEOUT;
        if(!redisLock.lock(productId, String.valueOf(time))){
            System.out.println("101,人太多了,重新来一次😯");
        }

        //1.查询该商品库存，0的话活动结束
        int stockNum = stock.get(productId);

        if (stockNum==0){
            System.out.println("100,活动结束");
        }else {
            //2.下单（模拟用户不用ID）
            orders.put(KeyUtil.genUniqueKey(), productId);
            //3.减库存
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

        //解锁
        redisLock.unlock(productId, String.valueOf(time));
    }

    @Override
    public String query(String productId) {
        return this.queryMap(productId);
    }

}
