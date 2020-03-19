package com.rabbit.rabbit01;

import org.junit.Test;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.topic.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.topic.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"person.*"}
    ))
    public void listen(String msg) {
        System.out.println("person 接收到消息：" + msg);
    }

    // 通配规则不同，接收不到消息
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.topic.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.topic.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"money.*"}
    ))
    public void listen2(String msg) {
        System.out.println("money Student 接收到消息：" + msg);
    }



    /**
     Topic类型的Exchange与Direct相比，都是可以根据RoutingKey把消息路由到不同的队列。只不过Topic类型Exchange可以让队列在绑定Routing key 的时候使用通配符！

     Routingkey 一般都是有一个或多个单词组成，多个单词之间以”.”分割，例如： user.insert

     通配符规则	举例
     #：匹配一个或多个词	person.#：能够匹配person.insert.save 或者 person.insert
     *：匹配不多不少恰好1个词	person.*：只能匹配person.insert

     **/


    /* 订阅模型-Topic (主题模式)*/
    @Test
    public void topic() throws InterruptedException {
        rabbitTemplate.convertAndSend("spring.topic.exchange", "person.insert", "增加人员");
        rabbitTemplate.convertAndSend("spring.topic.exchange", "person.delete", "删除人员");
        rabbitTemplate.convertAndSend("spring.topic.exchange", "money.insert", "加钱");
        rabbitTemplate.convertAndSend("spring.topic.exchange", "money.delete", "减钱");
        Thread.sleep(5000);
    }




}

