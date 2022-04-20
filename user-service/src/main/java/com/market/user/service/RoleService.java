package com.market.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.user.dao.RoleRepository;
import com.market.user.entity.Role;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role createNewRole(Role role) {
		return roleRepository.save(role);
	}
}
