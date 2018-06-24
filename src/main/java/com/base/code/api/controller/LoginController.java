package com.base.code.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.code.service.TestService;

@RestController
@RequestMapping("/test")
public class LoginController {

	@Autowired
	private TestService testService;
	
	@GetMapping("")
	public ResponseEntity<String> triigerMail(){
		System.out.println("Test Service");
		return ResponseEntity.ok(testService.getTest());
	}
}
