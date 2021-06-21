package com.example.demo.queue;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 队列绑定同一个交换机
 * @author JiangHaoTing
 * @create: 2021-04-12 11:34
 */

@Configuration
public class FanoutQueueConfig {

    /**
     * 声明队列名.
     */
    private final String fanout1 = "fanoutQueue1";

    private final String fanout2 = "fanoutQueue2";

    /**
     * 声明交换机的名字.
     */
    private final String fanoutExchange = "fanoutExchange";

    /**
     * 声明交换机.
     */
    @Bean()
    public FanoutExchange exchange() {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    public Queue fanoutQueue1() {
        /*  durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
           exclusive:默认也是false,只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
           autoDelete:是否自动删除,默认也是false,当没有生产者或者消费者使用此队列，该队列会自动删除。
           return new Queue("TestDirectQueue",true,true,false);
           一般设置一下队列的持久化就好,其余两个就是默认false*/
        return new Queue(fanout1);
    }
    @Bean
    public Queue fanoutQueue2() {
        return new Queue(fanout2);
    }

    @Bean
    public Binding bindingFanoutQueue1() {
        return BindingBuilder.bind(fanoutQueue1()).to(exchange());
    }

    @Bean
    public Binding bindingFanoutQueue2() {
        return BindingBuilder.bind(fanoutQueue2()).to(exchange());
    }




//
//
//    @Bean
//    public Queue fanoutQueue3() {
//        return new Queue("fanoutQueue3");
//    }



    /**
     * 队列绑定交换机，也可在可视化工具中进行绑定.
     *
     * @return
     */




//    @Bean
//    public Binding bindingFanoutQueue3() {
//        return BindingBuilder.bind(fanoutQueue3()).to(exchange());
//    }
}
