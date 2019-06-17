package com.lanyu.testclient.feignclient;

import com.lanyu.testclient.TestclientApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Description: 接受mq消息测试
 *
 * @Author: 朱佳明
 * Date: 2019-02-21
 * Time: 8:31 PM
 */
@Component
public class FeignMapperTest extends TestclientApplicationTests {



    @Test
    public void getMsg() {


    }
}