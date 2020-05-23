package com.majortom.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.23. \ 11:34
 * @copyright &copy; xuetang9
 * @address
 */
@Configuration
public class TopicQueueConfig {

    @Bean
    public Queue topicTestQueue1(){
        return new Queue("topicTestQueue1",true);
    }

    @Bean
    public Queue topicTestQueue2(){
        return new Queue("topicTestQueue2",true);
    }

    @Bean
    public TopicExchange topicTestExchange(){
        return new TopicExchange("topicTestExchange",true,false);
    }

    @Bean
    Binding bindingDirectTopic1(){
        return BindingBuilder.bind(topicTestQueue1()).to(topicTestExchange()).with("top.a.b");
    }

    @Bean
    Binding bindingDirectTopic2(){
        return BindingBuilder.bind(topicTestQueue2()).to(topicTestExchange()).with("*.a");
    }
}
