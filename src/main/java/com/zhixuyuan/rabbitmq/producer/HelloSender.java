package com.zhixuyuan.rabbitmq.producer;

import com.zhixuyuan.rabbitmq.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Classname HelloSender
 * @Description TODO
 * @Date 2020/1/7 16:48
 * @Created by 王金宝
 */
@Component
public class HelloSender {

    @Autowired
    AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
//        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_A, context);
    }
}
