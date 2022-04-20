package com.market.gateway.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.market.gateway.dto.UserDto;

@FeignClient(name="user")
@RibbonClient(name="user")
public interface UserClient {
	@GetMapping("/auth/user")
	public UserDto loadUserByUserName(@RequestParam String username);
	}
