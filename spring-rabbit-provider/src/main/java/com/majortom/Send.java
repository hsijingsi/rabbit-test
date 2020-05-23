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
 * @date 2020.05.22. \ 21:11
 * @copyright &copy; xuetang9
 * @address
 */
public class Send {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-rabbit.xml");
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        Map<String,Object> map = new HashMap<>();
        map.put("name","蚊子李");
        map.put("age",25);
        /**
         * 扇形交换机发送，配置文件处打开扇形交换机相关配置
         */
//        template.convertAndSend(JSON.toJSONString(map));
        /**
         * 直连交换机发送，配置文件处打开直连交换机相关配置
         */
//        template.convertAndSend("delete",JSON.toJSONString(map));
        /**
         * topic交换机发送，配置文件处打开topic交换机相关配置
         */
        template.convertAndSend("top.a",JSON.toJSONString(map));
        ctx.close();
    }
}
