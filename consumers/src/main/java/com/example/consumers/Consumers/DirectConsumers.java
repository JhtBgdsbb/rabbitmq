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
 * @create: 2021-04-14 21:08
 */

@Component
public class DirectConsumers {

//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "TestDirectQueue", durable = "true"),
//            exchange = @Exchange(
//                    value = "direct",
//                    ignoreDeclarationExceptions = "true"
//            ),
//            key = {"direct.queue"}
//    ))
    @RabbitListener(queuesToDeclare = @Queue(value="TestDirectQueue"))
    public void readMessage(Message testMessage, Channel channel) throws IOException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是消费信息directQueue11 : " + new String(testMessage.getBody()));
    }


    /**
     * 自动生成queue绑定direct 路由key为 direct-queue
     * @param testMessage
     * @param channel
     * @throws IOException
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "TestDirectQueue1", durable = "true"),
            exchange = @Exchange(
                    value = "direct",
                    ignoreDeclarationExceptions = "true"
            ),
            key = {"direct-queue"}
    ))
    @RabbitListener(queuesToDeclare = @Queue(value="TestDirectQueue1"))
    public void readMessage1(Message testMessage, Channel channel) throws IOException {
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是消费信息directQueue22 : " + new String(testMessage.getBody()));
    }


//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "TestDirectQueue2", durable = "true"),
//            exchange = @Exchange(
//                    value = "direct",
//                    ignoreDeclarationExceptions = "true"
//            ),
//            key = {"direct-queue"}
//    ))
    @RabbitListener(queuesToDeclare = @Queue(value="TestDirectQueue2"))
    private void readMessage2(Message testMessage, Channel channel) throws IOException{
        channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
        System.out.println("我是消费信息directQueue333 : " + new String(testMessage.getBody()));
    }

}
