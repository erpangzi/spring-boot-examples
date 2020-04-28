package com.rabbit.rabbit.hello;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello") //可以标注在类上面，需配合 @RabbitHandler 注解一起使用
public class HelloReceiver {

    //标注在类上面表示当有收到消息的时候，就交给 @RabbitHandler 的方法处理，具体使用哪个方法处理，根据 MessageConverter 转换后的参数类型
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }



    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "topic.exchange",durable = "true",type = "topic"),
            value = @Queue(value = "consumer_queue",durable = "true"),
            key = "key.#"
    ))
    @RabbitHandler
    public void processMessage1(Message message) {
        System.out.println(message);
    }


    @RabbitHandler
    public void processMessage2(byte[] message) {
        System.out.println(new String(message));
    }


    @RabbitListener(queues = "helloObj")
    @RabbitHandler
    public void processMessage3(Message message) {
        System.out.println(message);
    }

}
