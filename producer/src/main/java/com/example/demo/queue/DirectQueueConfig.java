package com.example.demo.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiangHaoTing
 * @create: 2021-04-14 20:54
 */

/**
 * 队列绑定交换机
 */
@Configuration
public class DirectQueueConfig {

    public Queue TestDirectQueue(){
        return new Queue("TestDirectQueue",true);
    }


    public Queue TestDirectQueue2(){
        return new Queue("TestDirectQueue2",true);
    }

    /**
     * Direct交换机
     *
     * @return
     */
    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("direct", true, false);
    }

   /**
     * 绑定  将队列和交换机绑定, 并设置用于匹配键：direct.queue
     *
     * @return
     */
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("direct.queue");
    }

    @Bean
    Binding bindingDirect2() {
        return BindingBuilder.bind(TestDirectQueue2()).to(TestDirectExchange()).with("direct-queue");
    }

}
