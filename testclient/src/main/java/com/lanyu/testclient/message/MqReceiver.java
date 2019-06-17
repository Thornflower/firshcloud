package com.lanyu.testclient.message;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description: 结束mq消息
 *
 * @Author: 朱佳明
 * Date: 2019-02-21
 * Time: 8:27 PM
 */
@Component
public class MqReceiver {


    /**
    *
    * 功能描述：这个mq 实例  需要手动创建队列
    *
    * @param
    * @return
    * @author zjm
    * @date 2019/2/22 10:14 AM
    */
    /*@RabbitListener(queues = "myQueue")
    public void process(String message){
        System.out.println("MqReceiver==="+message);
    }*/

    /**
    *
    * 功能描述：这个mq实例 自动创建队列
    *
    * @param
    * @return
    * @author zjm
    * @date 2019/2/22 10:23 AM
    */
   /* @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void process(String message){
        System.out.println("MqReceiver==="+message);
    }*/


    /**
    *
    * 功能描述：自动创建  Exchange和 Queue绑定
    *
    * @param
    * @return
    * @author zjm
    * @date 2019/2/22 10:24 AM
    */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message){
        System.out.println("MqReceiver==="+message);
    }
}
