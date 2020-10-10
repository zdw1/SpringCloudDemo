package com.init.springCloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.init.springCloud.service.impl.SchedualServiceHiHystric;

@FeignClient(value = "eureka-client", fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	String sayHiFromClientOne(@RequestParam(value = "name") String name);
}

