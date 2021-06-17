package com.example.consumers.Consumers;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;

import java.io.IOException;

/**
 * 监听的队列名称 simpleQueue
 * @author JiangHaoTing
 * @create: 2021-04-09 19:41
 */

@Component
public class SimpleConsumers {

    @RabbitListener(queues = "simpleQueue")
    public void readMessage(Message  testMessage, Channel channel) throws IOException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是消费信息  : " + new String(testMessage.getBody()));
    }

}
