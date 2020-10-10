package com.init.springCloud.service.impl;

import org.springframework.stereotype.Component;

import com.init.springCloud.service.SchedualServiceHi;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{

	@Override
	public String sayHiFromClientOne(String name) {
		// TODO Auto-generated method stub
		return "soory" + name;
	}

}
