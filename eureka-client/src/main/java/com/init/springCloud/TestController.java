package com.init.springCloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {

	@Value("${server.port}")
	String port;
	
	@RequestMapping("/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public String test(@RequestParam(value = "name", defaultValue = "forezp") String name) {
		return "hi" + name + ", i am from port:"+ port;
	}
	
	public String hiError(String name) {
		return "hi,"+name+",sorry,error!";
	}
}
