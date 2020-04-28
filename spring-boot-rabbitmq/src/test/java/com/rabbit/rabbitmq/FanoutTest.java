package com.rabbit.rabbitmq;

import com.rabbit.rabbit.fanout.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest {

	@Autowired
	private FanoutSender sender;

	@Test
	public void fanoutSender() throws Exception {
		sender.send();
	}


	/*
Sender : hi, fanout msg
fanout Receiver B: hi, fanout msg
HelloReceiver收到  : hi, fanout msg 收到时间Mon Apr 27 11:08:38 CST 2020
receiver success
fanout Receiver C: hi, fanout msg
fanout Receiver A  : hi, fanout msg

	 */

}