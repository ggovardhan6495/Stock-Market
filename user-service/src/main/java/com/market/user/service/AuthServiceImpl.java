package com.market.user.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.market.user.dao.UserRepository;
import com.market.user.dto.SignInRequest;
import com.market.user.dto.SignInResponse;
import com.market.user.dto.UserDto;
import com.market.user.entity.User;
import com.market.user.exception.AuthException;
import com.market.user.util.Constants;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AuthServiceImpl implements UserDetailsService {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationManager;

	public SignInResponse generateJwtToken(SignInRequest request) throws AuthException {
		SignInResponse response = new SignInResponse();
		try {
			String userName = request.getUserName();
			String userPassword = request.getPassword();
			Authentication authentication = authenticate(userName, userPassword);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String newGeneratedToken = jwtUtil.generateToken(authentication);
			response.setTokenType(Constants.BEARER);
			response.setAccessToken(newGeneratedToken);
			response.setResponseDescription("Token Generated Successfully!!");
		} catch (Exception e) {
			log.error("Exception occured while generating JWT Token ::{}", e.getMessage());
			response.setResponseStatus(Constants.FAIL);
			response.setResponseDescription(e.getMessage());
		}
		return response;
	}

	private Authentication authenticate(String userName, String userPassword) throws AuthException {
		try {
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
		} catch (DisabledException e) {
			throw new AuthException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new AuthException("INVALID_CREDENTIALS", e);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Optional<User> user = userRepository.findByUsername(username);
			return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
					user.get().getPassword(), grantedAuthority(user.get()));
		} catch (Exception e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

	public UserDto getUserByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull())
					.setMatchingStrategy(MatchingStrategies.STRICT);
			return modelMapper.map(user.get(), UserDto.class);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	private Set grantedAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRole().forEach(role -> 
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
		);
		return authorities;
	}

}
