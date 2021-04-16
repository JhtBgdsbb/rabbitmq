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



@Component
public class WorkConsumers {

    @RabbitListener(queues = "workQueue")
    public void readMessage1(Message testMessage, Channel channel) throws IOException, InterruptedException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是消费信息111  : " + new String(testMessage.getBody()));
        Thread.sleep(5000);
    }

    @RabbitListener(queues = "workQueue")
    public void readMessage2(Message  testMessage, Channel channel) throws IOException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是消费信息222  : " + new String(testMessage.getBody()));
    }
}
