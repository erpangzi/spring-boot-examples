package com.rabbit.rabbit.hello;



import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component //普通模式
public class HelloSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hello " + new Date();
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello", context);

	}

	public void send01(){
		Message message = new Message("hello01".getBytes(),new MessageProperties());
		// 发送消息到默认的交换器，默认的路由键
		rabbitTemplate.convertAndSend(message);
		// 发送消息到指定的交换器，指定的路由键
		rabbitTemplate.convertAndSend("direct.exchange","key.1",message);

	}

}