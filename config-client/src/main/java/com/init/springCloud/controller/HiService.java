package com.init.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HiService {

	@Value("${foo}")
	String foo;
	
	@Value("${democonfigclient.message}")
    String message ;
	
	@RequestMapping(value = "/hi")
	public String hi() {
		return foo +"====" + message;
	}
}
