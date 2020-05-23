package com.majortom;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.21. \ 17:07
 * @copyright &copy; xuetang9
 * @address
 */
public class Recv1 {
    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        channel.basicQos(1);
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        newApi1(channel);
        newApi2(channel);
    }



    //手动确认
    private static void newApi1(Channel channel) throws IOException {
        DeliverCallback deliverCallback = (consumerTag, delivery)->{
            System.out.println(new String(delivery.getBody()));
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        channel.basicConsume(QUEUE_NAME,false,deliverCallback,consumerTag->{});
    }

    //此方法自动确认
    private static void newApi2(Channel channel) throws IOException {
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body, "utf-8"));
//                channel.basicAck(envelope.getDeliveryTag(),false);  false表示手动确认
//                channel.basicAck(envelope.getDeliveryTag(),true);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
