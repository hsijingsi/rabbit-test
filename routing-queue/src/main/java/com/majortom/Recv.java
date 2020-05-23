package com.majortom;

import com.rabbitmq.client.*;
//import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.21. \ 22:12
 * @copyright &copy; xuetang9
 * @address
 */
public class Recv {
    private static final String QUEUE_NAME = "topic-queue1";
    private static final String ROUTING_EXCHANGE = "topic-exchange";

    public static void main(String[] args) throws Exception{

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.exchangeDeclare(ROUTING_EXCHANGE,"topic");


        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, ROUTING_EXCHANGE, "topic.#");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body,"utf-8"));
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
