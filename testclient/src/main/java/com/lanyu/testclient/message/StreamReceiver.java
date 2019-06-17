package com.lanyu.testclient.message;

import com.lanyu.testclient.streamclient.StreamClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author: 朱佳明
 * Date: 2019-02-22
 * Time: 12:33 PM
 */
@Component
@EnableBinding({StreamClient.class})
public class StreamReceiver {


    /**
    *
    * 功能描述：普通发送mq消息
    *
    * @param
    * @return
    * @author zjm
    * @date 2019/2/22 2:30 PM
    */
    /*@StreamListener(StreamClient.OUTPUT)
    public void process(Object message){
        //打印接收过来的信息
        System.out.println("StreamReceiver=="+message);

    }*/


    /**
    *
    * 功能描述：接收到mq 消息后  再发送mq 消息
    *
    * @param
    * @return
    * @author zjm
    * @date 2019/2/22 2:30 PM
    */
    @StreamListener(StreamClient.OUTPUT)
    @SendTo(StreamClient.OUTPUT2)
    public String process(Object message){
        //打印接收过来的信息
        System.out.println("StreamReceiver=="+message);
        //再次发送mq消息
        return "girlfriend";
    }

    @StreamListener(StreamClient.OUTPUT2)
    public void process2(Object message){
        //打印接收过来的信息
        System.out.println("StreamReceiver2=="+message);

    }
}
