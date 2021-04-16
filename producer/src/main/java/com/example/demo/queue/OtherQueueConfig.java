package com.example.demo.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiangHaoTing
 * @create: 2021-04-12 19:19
 */

@Configuration
public class OtherQueueConfig {

    /**
     * 声明交换机的名字.
     */
    private final String fanoutExchange = "fanoutExchange";

    @Bean
    public Queue otherQueue2() {//ignore-declaration-exceptions
        return new Queue("otherQueue2") ;
    }

    /**
     * 队列绑定交换机，也可在可视化工具中进行绑定.
     *
     * @return
     */
    @Bean
    public Binding bindingFanoutQueue4() {
        return BindingBuilder.bind(otherQueue2()).to(new FanoutExchange(fanoutExchange));
    }
}
