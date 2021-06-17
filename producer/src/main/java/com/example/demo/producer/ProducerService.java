package com.example.demo.producer;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author JiangHaoTing
 * @create: 2021-04-12 09:42
 */

@Component
public class ProducerService {

    @Resource
    private RabbitTemplate rabbitTemplate;


    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory defaultConnectionFactory){
        return new RabbitAdmin(defaultConnectionFactory);
    }

    @Resource
    private RabbitAdmin rabbitAdmin;

    public void simpleSendMessage(){
        for (int i = 0; i < 5; i++) {
            String message = "简单消息" + i;
            System.out.println("我是生产信息的：" + message);
            rabbitTemplate.convertAndSend( "simpleQueue", message);
        }
    }

    public void workSendMessage() {
        for (int i = 0; i < 5; i++) {
            String message = "工作消息" + i;
            System.out.println("我是生产信息的：" + message);
            rabbitTemplate.convertAndSend("workQueue", message);
        }
    }

    public void fanoutSendMessage() {
        for (int i = 0; i < 5; i++) {
            String message = "订阅模式消息" + i;
            System.out.println("我是生产信息的：" + message);
            rabbitTemplate.convertAndSend("fanoutExchange","", message);
        }
    }

    public void directSendMessage() {
        for (int i = 0; i < 5; i++) {
            String message = "Direct(路由模式)" + i;
            System.out.println("我是生产信息的：" + message);
            rabbitTemplate.convertAndSend("direct", "direct.queue", message);
        }
    }

    public void directSendMessage1() {
        for (int i = 0; i < 5; i++) {
            String message = "Direct(路由模式)1" + i;
            System.out.println("我是生产信息的1：" + message);
            rabbitTemplate.convertAndSend("direct", "direct-queue", message);
        }
    }

    public void directSendMessage2() {
        for (int i = 0; i < 5; i++) {
            String message = "Direct(路由模式)2" + i;
            System.out.println("我是生产信息的2：" + message);
            rabbitTemplate.convertAndSend("direct", "direct-queue", message);
        }
    }

    public void topicSendMessage() {
        for (int i = 0; i < 5; i++) {
            String message = "Direct(主题模式)" + i;
            System.out.println("我是生产信息的：" + message);
            rabbitTemplate.convertAndSend("topic", "person.one", message);
        }
    }



}
