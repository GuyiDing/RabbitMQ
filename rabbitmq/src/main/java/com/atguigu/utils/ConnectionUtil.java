package com.atguigu.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @title: ConnectionUtil
 * @Author LiuXianKun
 * @Date: 2020/9/26 17:34
 */
public class ConnectionUtil {
    public static Connection getConnection() throws Exception {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2.设置参数
        //主机地址;默认为 localhost
        connectionFactory.setHost("192.168.204.130");
        //连接端口;默认为 5672
        connectionFactory.setPort(5672);
        //虚拟主机名称;默认为 /
        connectionFactory.setVirtualHost("/atguigu");
        //连接用户名；默认为guest
        connectionFactory.setUsername("admin");
        //连接密码；默认为guest
        connectionFactory.setPassword("123456");
        //3.创建连接
        return connectionFactory.newConnection();
    }
}
