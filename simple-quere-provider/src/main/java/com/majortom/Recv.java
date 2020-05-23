package com.majortom;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.21. \ 16:28
 * @copyright &copy; xuetang9
 * @address
 */


import com.rabbitmq.client.*;

import java.io.IOException;

public class Recv {

    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnetionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);


//        newApi2(channel);

        newApi1(channel);
    }


    //方式一：实现DeliverCallback函数式接口
    private static void newApi2(Channel channel) throws IOException {
        //消息回调函数
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        //监听队列，执行回调
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });
    }

    private static void newApi1(Channel channel) throws IOException {
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(consumerTag);
                System.out.println(new String(body));
            }

        };
        channel.basicConsume(QUEUE_NAME,false,consumer);
    }
}

