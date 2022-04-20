package com.market.user.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class BaseResponseVo {
	private LocalDateTime timeStamp;
	private String responseStatus;
	private String responseDescription;
	private HttpStatus status;
	
	public BaseResponseVo() {
		timeStamp = LocalDateTime.now();
	}
}
