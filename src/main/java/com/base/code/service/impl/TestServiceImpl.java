package com.base.code.service.impl;

import org.springframework.stereotype.Service;

import com.base.code.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public String getTest() {
		return "Test Service";
	}

}
