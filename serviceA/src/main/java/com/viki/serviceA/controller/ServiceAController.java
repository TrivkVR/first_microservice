package com.viki.serviceA.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {
	
	@GetMapping("/helloWorld")
	public String getHello() {
		return "Hello World from Service A!";
	}
}
