package com.majortom.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.23. \ 13:39
 * @copyright &copy; xuetang9
 * @address
 */
@Service
@RabbitListener(queues = "simpleTestQueue")
public class SimpleService {

    @RabbitHandler
    public void simpleTestQueueListener(String map){
        System.out.println("simpleTestQueueListener:"+map);
    }
}
