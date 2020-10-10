package com.init.springCloud;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix //开启断路器
@EnableHystrixDashboard //开启HystrixDashboard
@EnableCircuitBreaker
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
	/**
	 * 查看springboot在启动的时候为我们注入了哪些bean
	 * @param ctx
	 * @return
	 */
//	@Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
// 
//        	System.out.println("Let's inspect the beans provided by Spring Boot:");
// 
//        	String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
// 
//        };
//	}

}
