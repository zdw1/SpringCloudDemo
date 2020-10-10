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
public class MiyaController {

	private static final Logger LOG = LoggerFactory.getLogger(MiyaController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@RequestMapping("/hi")
	public String home() {
		LOG.info("hi is being called");
		return "hi i'm miya!";
	}
	
	@RequestMapping("/miya")
	public String info() {
		LOG.info("info is being called");
		return restTemplate.getForObject("http://localhost:8988/info", String.class);
	}
}
