package com.example.consumers.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * 监听的队列名称 myQueue
 * @author JiangHaoTing
 * @create: 2021-04-09 19:41
 */

@Component
@RabbitListener(queues = "myQueue")
public class DirectReceiver {

    @RabbitHandler
    public void process(Map testMessage, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
       System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
       try {
           channel.basicAck(deliveryTag,true);
       }catch (Exception e){
           e.printStackTrace();
       }

    }

}
