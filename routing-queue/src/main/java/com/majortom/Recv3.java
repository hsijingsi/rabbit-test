package com.majortom;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.21. \ 22:19
 * @copyright &copy; xuetang9
 * @address
 */
public class Recv3 {
    private static final String QUEUE_NAME = "topic-queue3";
    private static final String ROUTING_EXCHANGE = "topic-exchange";

    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, ROUTING_EXCHANGE, "#");
        channel.queueBind(QUEUE_NAME, ROUTING_EXCHANGE, "*.topic");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//        // 监听队列，手动返回完成
//        channel.basicConsume(QUEUE_NAME, false, consumer);
//
//        // 获取消息
//        while (true) {
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            String message = new String(delivery.getBody());
//            System.out.println(" [Recv2] Received '" + message + "'");
//            Thread.sleep(10);
//
//            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
//        }
    }
}
