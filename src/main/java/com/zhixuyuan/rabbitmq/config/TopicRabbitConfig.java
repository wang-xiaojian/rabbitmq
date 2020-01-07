package com.zhixuyuan.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname TopicRabbitConfig
 * @Description TODO
 * @Date 2020/1/7 17:51
 * @Created by 王金宝
 */
@Configuration
public class TopicRabbitConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";
    // 创建队列
    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }
    // 创建队列
    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }
    // 将对列绑定到Topic交换器
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }
    // 将对列绑定到Topic交换器
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    // 将对列绑定到Topic交换器 采用#的方式
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
