package com.example.demo.controller;

import com.example.demo.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author JiangHaoTing
 * @create: 2021-04-09 19:44
 */


@RequestMapping("rabbitmq")
@RestController
public class SendMessageController {

    @Resource
    private ProducerService producerService;


    @GetMapping("/simpleSendMessage")
    public String sendDirectMessage() {
        producerService.simpleSendMessage();
        return "simple ok";
    }

    @GetMapping("/workSendMessage")
    public String workSendMessage() {
        producerService.workSendMessage();
        return "work ok";
    }
    @RequestMapping(value = "fanoutQueueTest")
    public String fanoutQueueTest() {
        producerService.fanoutSendMessage();
        return "success";
    }

    @RequestMapping(value = "directQueueTest")
    public String directQueueTest() {
        producerService.directSendMessage();
        return "success";
    }

    @RequestMapping(value = "directQueueTest1")
    public String directQueueTest1() {
        producerService.directSendMessage1();
        return "success";
    }

    @RequestMapping(value = "directQueueTest2")
    public String directQueueTest2() {
        producerService.directSendMessage2();
        return "success";
    }

    @RequestMapping(value = "topicQueueTest")
    public String topicQueueTest() {
        producerService.topicSendMessage();
        return "success";
    }



}
