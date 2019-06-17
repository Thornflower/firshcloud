package com.lanyu.getaway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * Description: 限流
 *
 * @Author: 朱佳明
 * Date: 2019-02-23
 * Time: 1:44 PM
 */
public class RateLimitFilter extends ZuulFilter {


    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);


    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //优先级最高
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //不添参数就是去取一个令牌  如果没有拿到令牌  报异常
        if (!RATE_LIMITER.tryAcquire()){
            System.out.println("报异常");
        }
        return null;
    }
}
