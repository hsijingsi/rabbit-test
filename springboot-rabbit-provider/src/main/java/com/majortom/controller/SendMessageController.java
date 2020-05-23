package com.majortom.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.23. \ 11:45
 * @copyright &copy; xuetang9
 * @address
 */
@RestController
public class SendMessageController {

    private static final String SIMPLE_TEST_QUEUE = "simpleTestQueue";
    private static final String WORK_TEST_QUEUE = "workTestQueue";

    private static final String DIRECT_TEST_EXCHANGE = "directTestExchange";
    private static final String FANOUT_TEST_EXCHANGE = "fanoutTestExchange";
    private static final String TOPIC_TEST_EXCHANGE = "topicTestExchange";

    @Autowired
    RabbitTemplate rabbitTemplate;

    private Map<String, Object> getStringObjectMap() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        return map;
    }

    @GetMapping("simpleQueueMessageSend")
    public String simpleQueueMessageSend(){
        Map<String, Object> map = getStringObjectMap();
        rabbitTemplate.convertAndSend(SIMPLE_TEST_QUEUE, JSON.toJSONString(map));
        return "ok";
    }



    @GetMapping("workQueueMessageSend")
    public String workQueueMessageSend(){
        Map<String, Object> map = getStringObjectMap();
        rabbitTemplate.convertAndSend(WORK_TEST_QUEUE,JSON.toJSONString(map));
        return "ok";
    }

    @GetMapping("workQueueMessageSendFor")
    public String workQueueMessageSendFor(){
        Map<String, Object> map = getStringObjectMap();
        for (int i = 0; i < 100; i++) {

            rabbitTemplate.convertAndSend(WORK_TEST_QUEUE,i+"");
        }
        return "ok";
    }

    @GetMapping("directQueueMessageSend")
    public String directQueueMessageSend(){
        Map<String, Object> map = getStringObjectMap();
        rabbitTemplate.convertAndSend(DIRECT_TEST_EXCHANGE,"info",JSON.toJSONString(map));
        return "ok";
    }

    @GetMapping("fanoutQueueMessageSend")
    public String fanoutQueueMessageSend(){
        Map<String, Object> map = getStringObjectMap();
        rabbitTemplate.convertAndSend(FANOUT_TEST_EXCHANGE,"",JSON.toJSONString(map));
        return "ok";
    }

    @GetMapping("topicQueueMessageSend")
    public String topicQueueMessageSend(){
        Map<String, Object> map = getStringObjectMap();
        rabbitTemplate.convertAndSend(TOPIC_TEST_EXCHANGE,"top.a",JSON.toJSONString(map));
        return "ok";
    }

}
