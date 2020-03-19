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
public class FanoutListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.fanout.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.fanout.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void listen(String msg) {
        System.out.println("订阅模式1 接收到消息：" + msg);
    }

    // 队列2（第二个人），同样能接收到消息
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.fanout2.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.fanout.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void listen2(String msg) {
        System.out.println("订阅模式2 接收到消息：" + msg);
    }


    /**
     订阅模型-Fanout也成为广播模式，流程如下
     1.可以有多个消费者
     2.每个消费者有自己的队列
     3. 每个队列都要绑定到Exchange（交换机）
     4. 生产者发送的消息，只能发送到交换机，交换机来决定要发给哪个队列，生产者无法决定。
     5. 交换机把消息发送给绑定过的所有队列
     6. 队列的消费者都能拿到消息。实现一条消息被多个消费者消费

     **/


    /*订阅模型-Fanout*/
    @Test
    public void fanout() throws InterruptedException {
        String msg = "订阅模式";
        for (int i = 0; i < 10; i++) {
            // 这里注意细节，第二个参数需要写，否则第一个参数就变成routingKey了
            rabbitTemplate.convertAndSend("spring.fanout.exchange", "", msg + i);
        }
        Thread.sleep(5000);
    }




}

