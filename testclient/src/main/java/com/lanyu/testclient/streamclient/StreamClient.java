package com.lanyu.testclient.streamclient;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * Description: stream 发送  接收方法  正式版两者要区分开
 *
 * @Author: 朱佳明
 * Date: 2019-02-22
 * Time: 12:27 PM
 */
@Component
public interface StreamClient {

    //接收的队列名称
    String INPUT = "input";
    //发送的队列名称
    String OUTPUT = "output";


    String OUTPUT2 = "output2";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();


    @Output(StreamClient.OUTPUT2)
    MessageChannel output2();
}
