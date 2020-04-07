package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class RabbitMQApplication {

	@Autowired
	private SpringContextUtil springContextUtil;
	@Autowired
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
                System.out.println(11111);
		SpringApplication.run(RabbitMQApplication.class, args);

		//启动WEB项目
		test002 bean = SpringContextUtil.getBean(test002.class);
		System.out.println(bean);

//		test002 bean1 = applicationContext.getBean(test002.class);
//		System.out.println(bean);
	}
}
