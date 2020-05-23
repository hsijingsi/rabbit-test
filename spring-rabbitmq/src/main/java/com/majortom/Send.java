package com.majortom;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.22. \ 17:14
 * @copyright &copy; xuetang9
 * @address
 */
public class Send {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext Context = new ClassPathXmlApplicationContext("classpath:src/main/spring-rabbit.xml");
        RabbitTemplate rabbitTemplate = Context.getBean(RabbitTemplate.class);
        Map map = new HashMap();
        map.put("name","wenzili");
        map.put("age",1);
        rabbitTemplate.convertAndSend(JSON.toJSONString(map));
//        rabbitTemplate.convertAndSend("wenzili");
    }
}
