package com.example.consumers.Consumers;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;


/**
 * @author JiangHaoTing
 * @create: 2021-04-16 15:20
 */

/**
 * 消费者
 */
@Configuration
public class TopicConsumers {
    @RabbitListener(queuesToDeclare = @Queue(value="topicQueue"))
    private void readMessage(Message testMessage) {
        System.out.println("我是消费信息topicQueue,routingKey:*.orange.* : " + new String(testMessage.getBody()));
    }

    @RabbitListener(queuesToDeclare = @Queue(value="topicQueue1"))
    private void readMessage1(Message testMessage){
        System.out.println("我是消费信息topicQueue1,routingKey:*.*.rabbit : " + new String(testMessage.getBody()));
    }
}
