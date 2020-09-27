package com.atguigu.rabbitmq;

import com.atguigu.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @title: producer
 * @Author LiuXianKun
 * @Date: 2020/9/26 17:18
 */
public class producer {
    static final String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();
        //声明队列
        /**
         * 参数1：队列名称
         * 参数2：是否定义持久化队列
         * 参数3：是否独占本次连接
         * 参数4：是否在不使用的时候自动删除队列
         * 参数5：队列其它参数
         */
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        //要发送的消息
        String message = "小兔子快跑";
        /**
         * 参数1：交换机名称，如果没有指定则使用默认Default Exchange
         * 参数2：路由key,简单模式可以传递队列名称
         * 参数3：消息其它属性
         * 参数4：消息内容
         */

        //发送 send
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        System.out.println("已经发送的消息" + message);
        //关闭资源
        channel.close();
        connection.close();

    }
}
