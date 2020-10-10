package com.init.springCloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@RestController
public class HiController {

	private static final Logger LOG = LoggerFactory.getLogger(HiController.class.getName());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping("/hi")
	public String callHome() {
		LOG.info("calling trace service-hi");
		return restTemplate.getForObject("http://localhost:8989/miya", String.class);
	}
	
	@RequestMapping("/info")
	public String info() {
		LOG.info("calling trace service-hi");
		return "I'm service-hi";
	}
	
	@Bean
	public Sampler defautSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
}
