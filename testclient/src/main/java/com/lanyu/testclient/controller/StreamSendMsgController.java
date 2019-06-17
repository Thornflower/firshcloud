package com.lanyu.testclient.controller;

import com.lanyu.testclient.streamclient.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Description: Spring cloud Stream 封装mq 用法
 *
 * @Author: 朱佳明
 * Date: 2019-02-22
 * Time: 12:36 PM
 */
@RestController
public class StreamSendMsgController {


    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void process(){
        String message = "now" + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }

}
