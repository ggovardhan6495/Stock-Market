package com.market.gateway.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Role {
	private Long id;
    private String roleName;
	private String roleDescription;
}
