package com.majortom.config;

import org.springframework.amqp.core.*;
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
public class FanoutQueueConfig {

    @Bean
    public Queue fanoutTestQueue1(){
        return new Queue("fanoutTestQueue1");
    }

    @Bean
    public Queue fanoutTestQueue2(){
        return new Queue("fanoutTestQueue2");
    }

    @Bean
    public FanoutExchange fanoutTestExchange(){
        return new FanoutExchange("fanoutTestExchange");
    }

    @Bean
    Binding bindingDirect1(){
        return BindingBuilder.bind(fanoutTestQueue1()).to(fanoutTestExchange());
    }

    @Bean
    Binding bindingDirect2(){
        return BindingBuilder.bind(fanoutTestQueue2()).to(fanoutTestExchange());
    }
}
