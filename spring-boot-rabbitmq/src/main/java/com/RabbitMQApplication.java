package com;


import com.InterfaceTest.TestInterface;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/App")
public class RabbitMQApplication {

	@Autowired
	private SpringContextUtil springContextUtil;
//	@Autowired
//	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
                System.out.println(11111);
		ConfigurableApplicationContext run = SpringApplication.run(RabbitMQApplication.class, args);

		//启动WEB项目
		test002 bean = SpringContextUtil.getBean(test002.class);
		System.out.println(bean);

//		RabbitMQApplication bean1 = applicationContext.getBean(RabbitMQApplication.class);

//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RabbitMQApplication.class);
//		test01 bean1 = applicationContext.getBean(test01.class);
//		System.out.println(bean1);
	}

	@PostMapping(value = "/App01",produces = "application/json;charset=UTF-8")
	public String App01(){
		return "服务可用~~";
	}

}
