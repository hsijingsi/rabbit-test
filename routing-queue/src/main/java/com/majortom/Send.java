package com.majortom;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.21. \ 21:45
 * @copyright &copy; xuetang9
 * @address
 */
public class Send {
    private static final String ROUTING_EXCHANGE = "topic-exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(ROUTING_EXCHANGE,"topic");
        String message = "删除";
        channel.basicPublish(ROUTING_EXCHANGE,"topic.a.a",null,message.getBytes());
        System.out.println("send"+message);
        channel.close();
        connection.close();
    }
}
