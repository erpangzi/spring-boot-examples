package com.rabbit.rabbit01;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleListener {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    // 通过注解自动创建 spring.simple.queue 队列
    @RabbitListener(queuesToDeclare = @Queue("spring.simple.queue"))
    public void listen(String msg) {
        System.out.println("简单队列 接收到消息：" + msg);
    }



    /*简单队列(模式)*/
    @Test
    public void contextLoads(){
        String msg = "这是一个简单队列模式";

        rabbitTemplate.convertAndSend("spring.simple.queue", msg );

    }


}

