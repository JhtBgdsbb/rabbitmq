package com.example.demo.queue;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiangHaoTing
 * @create: 2021-04-16 10:27
 */

@Configuration
public class TopicQueueConfig {


    @Bean
    public Queue topicQueue() {
        return new Queue("topicQueue") ;
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue("topicQueue1") ;
    }

    @Bean
    public TopicExchange TestTopicExchange() {
        return new TopicExchange("topic", true, false);
    }

    @Bean
    Binding BindingTopic(){
        return BindingBuilder.bind(topicQueue()).to(TestTopicExchange()).with("person.*");
    }


    @Bean
    Binding BindingTopic1(){
        return BindingBuilder.bind(topicQueue1()).to(TestTopicExchange()).with("person.*");
    }

}
