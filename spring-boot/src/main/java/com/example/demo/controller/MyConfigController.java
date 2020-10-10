package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyConfigController {
	
	@Autowired
	private ApplicationContext ctx;

	@GetMapping("/prod")
	@ResponseBody
	public String getName() {
		
		return ctx.getEnvironment().getProperty("test.user.name");
	}
}
