package com;

import com.testController.TestJSONController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class RabbitMQApplication {

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
                System.out.println(11111);
		SpringApplication.run(RabbitMQApplication.class, args);

		//启动WEB项目
//		TestJSONController testJSONController = applicationContext.getBean(TestJSONController.class);
//		System.out.println(testJSONController);
	}
}
