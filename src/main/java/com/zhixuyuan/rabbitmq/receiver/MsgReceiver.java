package com.zhixuyuan.rabbitmq.receiver;

import com.zhixuyuan.rabbitmq.config.RabbitConfig;
import com.zhixuyuan.rabbitmq.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname MsgReceiver
 * @Description TODO
 * @Date 2020/1/7 14:21
 * @Created by 王金宝
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @RabbitHandler
//    public void process(String content) {
//        logger.info("接收处理队列A当中的消息： " + content);
//    }
    @RabbitHandler
    public void process(User user) {
        System.out.println(1);
        logger.info("接收处理队列A当中的消息： " + user.getUsername());
    }
}
