package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    void contextLoads() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            String messageId = String.valueOf(UUID.randomUUID());
            String messageData = "test message, Hello Word!";
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> map = new HashMap<>();
            map.put("messageId", messageId);
            map.put("messageData", messageData);
            map.put("createTime", createTime);
            //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
            rabbitTemplate.convertAndSend("testMyQueue", "myTest", map);
//            Thread.sleep(10000);
        }

    }

}
