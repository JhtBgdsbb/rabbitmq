package com.example.consumers.Consumers;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author JiangHaoTing
 * @create: 2021-04-12 09:51
 */


/**
 * 消费者
 */
@Component
public class WorkConsumers {

    @RabbitListener(queues = "workQueue")
    public void readMessage1(Message testMessage) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("我是消费信息1 : " + new String(testMessage.getBody()));
    }

    @RabbitListener(queues = "workQueue")
    public void readMessage2(Message  testMessage){
        System.out.println("我是消费信息2  : " + new String(testMessage.getBody()));
    }
}
