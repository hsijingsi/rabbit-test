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
@RabbitListener(queues = "workTestQueue")
public class WorkService {

    @RabbitHandler
    public void workTestQueueListener(String map) throws InterruptedException {
        System.out.println("workTestQueueListener:"+map);
        Thread.sleep(100);
    }
}
