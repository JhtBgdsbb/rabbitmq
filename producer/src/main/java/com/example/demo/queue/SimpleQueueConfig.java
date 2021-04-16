package com.example.demo.queue;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JiangHaoTing
 * @create: 2021-04-09 19:30
 */

@Configuration
public class SimpleQueueConfig {
    /**
     * 队列 起名：myQueue
     *
     * @return
     */
    @Bean
    public Queue simpleQueue() {
       /*  durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
           exclusive:默认也是false,只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
           autoDelete:是否自动删除,默认也是false,当没有生产者或者消费者使用此队列，该队列会自动删除。
           return new Queue("TestDirectQueue",true,true,false);
           一般设置一下队列的持久化就好,其余两个就是默认false*/
        return new Queue("simpleQueue");
    }

//    /**
//     * Direct交换机 起名：testMyQueue
//     *
//     * @return
//     */
//    @Bean
//    DirectExchange TestDirectExchange() {
//        //  return new DirectExchange("TestDirectExchange",true,true);
//        return new DirectExchange("testMyQueue", true, false);
//    }
//
//    /**
//     * 绑定  将队列和交换机绑定, 并设置用于匹配键：myTest
//     *
//     * @return
//     */
//    @Bean
//    Binding bindingDirect() {
//        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("myTest");
//    }
//
//
//    @Bean
//    DirectExchange lonelyDirectExchange() {
//        return new DirectExchange("lonelyDirectExchange");
//    }
}
