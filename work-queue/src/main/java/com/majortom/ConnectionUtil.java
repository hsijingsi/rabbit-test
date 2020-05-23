package com.majortom;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.21. \ 16:59
 * @copyright &copy; xuetang9
 * @address
 */
public class ConnectionUtil {
    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("122.112.171.70");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        //虚拟主机需要先在rabbitmq管理页面创建，并且与账号关联，不设置虚拟主机是默认为/
        factory.setVirtualHost("/test");
        factory.setUsername("admin");
        factory.setPassword("admin");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
