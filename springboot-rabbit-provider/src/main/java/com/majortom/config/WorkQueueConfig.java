package com.majortom.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.23. \ 11:33
 * @copyright &copy; xuetang9
 * @address
 */
@Configuration
public class WorkQueueConfig {

    @Bean
    public Queue workTestQueue(){
        return new Queue("workTestQueue",true);
    }
}
