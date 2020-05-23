package com.majortom;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.21. \ 15:57
 * @copyright &copy; xuetang9
 * @address
 */


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
    //队列名称
    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnetionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        // 声明（创建）队列
        //queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        //5个参数的含义分别为：队列名称，是否持久化，是否排他，是否自动删除，队列的其他参数（默然为null）
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 消息内容
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}

