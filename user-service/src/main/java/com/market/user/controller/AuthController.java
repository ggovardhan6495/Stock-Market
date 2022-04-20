package com.market.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.user.dto.SignInRequest;
import com.market.user.dto.SignInResponse;
import com.market.user.dto.SignUpRequest;
import com.market.user.dto.SignUpResponse;
import com.market.user.dto.UserDto;
import com.market.user.service.AuthServiceImpl;
import com.market.user.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthServiceImpl authService;
	@Autowired
	private UserService userService;

	@PostMapping("/signin")
	public SignInResponse createJwtToken(@RequestBody SignInRequest request) throws Exception {
		return authService.generateJwtToken(request);
	}

	@PostMapping("/signup")
	public SignUpResponse registerNewUser(@RequestBody SignUpRequest request) {
		return userService.registerNewUser(request);
	}

	@GetMapping("/user")
	public UserDto loadUserByUserName(@RequestParam String username) {
		return authService.getUserByUsername(username);
	}
}
