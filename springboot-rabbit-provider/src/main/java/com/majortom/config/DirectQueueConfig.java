package com.majortom.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
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
public class DirectQueueConfig {

    @Bean
    public Queue directTestQueue(){
        return new Queue("directTestQueue",true);
    }

    @Bean
    public DirectExchange directTestExchange(){
        return new DirectExchange("directTestExchange",true,false);
    }

    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(directTestQueue()).to(directTestExchange()).with("info");
    }
}
