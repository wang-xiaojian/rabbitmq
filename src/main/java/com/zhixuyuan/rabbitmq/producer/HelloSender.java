package com.zhixuyuan.rabbitmq.producer;

import com.zhixuyuan.rabbitmq.config.RabbitConfig;
import com.zhixuyuan.rabbitmq.model.User;
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

//    public void send() {
//        String context = "hello " + new Date();
////        System.out.println("Sender : " + context);
//        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_A, context);
//    }

    public void send(User user) {
        System.out.println("Sender object: " + user.toString());
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_A, user);
    }

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }
}
