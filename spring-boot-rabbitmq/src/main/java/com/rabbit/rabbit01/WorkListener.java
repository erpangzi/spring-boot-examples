package com.rabbit.rabbit01;

import org.junit.Test;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 通过注解自动创建 spring.work.queue 队列
    @RabbitListener(queuesToDeclare = @Queue("spring.work.queue"))
    public void listen(String msg) {
        System.out.println("work模式 接收到消息：" + msg);
    }

    // 创建两个队列共同消费
    @RabbitListener(queuesToDeclare = @Queue("spring.work.queue"))
    public void listen2(String msg) {
        System.out.println("work模式二 接收到消息：" + msg);
    }


    /*work 模式*/
    @Test
    public void work() throws InterruptedException {
        String msg = "这是一个work模式";
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("spring.work.queue", msg + i);
        }
        Thread.sleep(5000);
    }


}
