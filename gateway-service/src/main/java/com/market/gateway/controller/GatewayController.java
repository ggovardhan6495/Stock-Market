package com.market.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

	@GetMapping("/")
	public String statusCheck() {
		return "Welcome to new Gateway Service";
	}
}
