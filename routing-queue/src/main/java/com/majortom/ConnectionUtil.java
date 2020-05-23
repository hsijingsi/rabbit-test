package com.majortom;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.21. \ 21:45
 * @copyright &copy; xuetang9
 * @address
 */
public class ConnectionUtil {
    public static Connection getConnection() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("122.112.171.70");
        factory.setPort(5672);
        factory.setVirtualHost("/test");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        return connection;
    }
}
