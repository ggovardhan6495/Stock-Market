package com.market.user.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.market.user.dao.RoleRepository;
import com.market.user.dao.UserRepository;
import com.market.user.dto.BaseResponseVo;
import com.market.user.dto.SignUpRequest;
import com.market.user.dto.SignUpResponse;
import com.market.user.entity.ERole;
import com.market.user.entity.Role;
import com.market.user.entity.User;
import com.market.user.exception.UserException;
import com.market.user.util.Constants;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public Optional<User> loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	private String getEncryptedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public SignUpResponse registerNewUser(SignUpRequest request) {
		SignUpResponse response = new SignUpResponse();
		try {
			if (!(userRepository.existsByUsername(request.getUsername()))) {
				User user = new User(request.getUsername(), request.getEmail(),
						getEncryptedPassword(request.getPassword()));
				Set<String> strRoles = request.getRoles();
				Set<Role> roles = new HashSet<>();
				if (CollectionUtils.isEmpty(strRoles)) {
					Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException(Constants.ROLE_ERROR));
					roles.add(userRole);
				} else {
					strRoles.forEach(role -> {
						switch (role) {
						case "admin":
							Role adminRole = roleRepository.findByRoleName(ERole.ROLE_ADMIN)
									.orElseThrow(() -> new RuntimeException(Constants.ROLE_ERROR));
							roles.add(adminRole);
							break;
						case "mod":
							Role modRole = roleRepository.findByRoleName(ERole.ROLE_MODERATOR)
									.orElseThrow(() -> new RuntimeException(Constants.ROLE_ERROR));
							roles.add(modRole);
							break;
						default:
							Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER)
									.orElseThrow(() -> new RuntimeException(Constants.ROLE_ERROR));
							roles.add(userRole);
						}
					});
				}
				user.setRole(roles);
				User registeredUser = userRepository.save(user);
				response.setUserName(registeredUser.getUsername());
				response.setEamil(registeredUser.getEmail());
				List<String> rolesList = registeredUser.getRole().stream().map(role ->{
					return role.getRoleName().toString();
				}).collect(Collectors.toList());
				response.setRoles(rolesList);
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseDescription("User Registered Successfully!!");
			} else {
				response.setResponseStatus(Constants.FAIL);
				response.setResponseDescription("Error:: UserName '" + request.getUsername() + "' is already taken");
			}
		} catch (Exception e) {
			response.setResponseStatus("Fail to registed user!!");
			response.setResponseDescription(e.getMessage());
		}
		return response;
	}

	@Override
	public BaseResponseVo deleteUser(String userName) {
		BaseResponseVo response = new BaseResponseVo();
		try {
			int isDeleted = userRepository.deleteUserByUsername(userName);
			if(isDeleted > 0) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseDescription("Deleted User: '"+userName+"'");
			}			
		} catch (Exception e) {
			log.error("Exception occured while deleting user:: {}", e.getMessage());
			response.setResponseStatus(Constants.FAIL);
			response.setResponseDescription(e.getMessage());
		}
		return response;
	}
}
