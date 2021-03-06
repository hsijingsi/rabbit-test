package com.majortom.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.23. \ 13:40
 * @copyright &copy; xuetang9
 * @address
 */
@Service
@RabbitListener(queues = "fanoutTestQueue1")
public class FanoutService {

    @RabbitHandler
    public void fanoutTestQueueListener1(String map){
        System.out.println("fanoutTestQueueListener1:"+map);
    }
}
