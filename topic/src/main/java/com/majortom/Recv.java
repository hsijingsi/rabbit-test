package com.majortom;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.21. \ 22:12
 * @copyright &copy; xuetang9
 * @address
 */
public class Recv {
    private static final String QUEUE_NAME = "test-routing-queue1";
    private static final String ROUTING_EXCHANGE = "routing-exchange";

    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {

        // 获取到连接以及mq通道
        Connection connection = ConnetionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.exchangeDeclare(ROUTING_EXCHANGE,"direct");


        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, ROUTING_EXCHANGE, "delete");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}
