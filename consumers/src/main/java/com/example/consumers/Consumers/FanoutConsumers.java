package com.example.consumers.Consumers;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author JiangHaoTing
 * @create: 2021-04-12 09:51
 */

@Component
public class FanoutConsumers {

    @RabbitListener(queues = "fanoutQueue1")
    public void readMessage1(Message testMessage, Channel channel) throws IOException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是消费信息11111  : " + new String(testMessage.getBody()));
    }

    @RabbitListener(queues = "fanoutQueue2")
    public void readMessage2(Message  testMessage, Channel channel) throws IOException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是消费信息222  : " + new String(testMessage.getBody()));
    }

//    @RabbitListener(queues = "otherQueue2")
//    @RabbitListener(queuesToDeclare = @Queue(value="otherQueue2"))
    @RabbitListener( bindings = @QueueBinding(
            value = @Queue(value = "otherQueue", durable = "true"),
            exchange = @Exchange(
                    value = "fanoutExchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void readMessage3(Message  testMessage, Channel channel) throws IOException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是其他项目消费信息2333  : " + new String(testMessage.getBody()));
    }

    @RabbitListener( bindings = @QueueBinding(
            value = @Queue(value = "otherQueue1", durable = "true"),
            exchange = @Exchange(
                    value = "fanoutExchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void readMessage5(Message  testMessage, Channel channel) throws IOException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是其他项目消费信息2333  : " + new String(testMessage.getBody()));
    }

    @RabbitListener( bindings = @QueueBinding(
            value = @Queue(value = "fanoutQueue3", durable = "true"),
            exchange = @Exchange(
                    value = "fanoutExchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void readMessage4(Message  testMessage, Channel channel) throws IOException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是消费信息4444  : " + new String(testMessage.getBody()));
    }
}
