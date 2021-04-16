package com.example.consumers.Consumers;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author JiangHaoTing
 * @create: 2021-04-16 15:20
 */

@Configuration
public class TopicConsumers {


    @RabbitListener(queuesToDeclare = @Queue(value="topicQueue"))
    private void readMessage(Message testMessage, Channel channel) throws IOException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是消费信息topicQueue : " + new String(testMessage.getBody()));
    }

    @RabbitListener(queuesToDeclare = @Queue(value="topicQueue1"))
    private void readMessage1(Message testMessage, Channel channel) throws IOException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是消费信息topicQueue1 : " + new String(testMessage.getBody()));
    }

}
