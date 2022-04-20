package com.market.user.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.user.dto.SignInRequest;
import com.market.user.entity.User;
import com.market.user.service.UserServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	@Value("${market.app.jwtSecret}")
	  private String jwtSecret="JwtSuperSecretKey";

	  @Value("${market.app.jwtExpirationMs}")
	  private int jwtExpirationMs = 864000000;

	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private AuthenticationManager authenticationManager;
	
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
  
        	SignInRequest creds = new ObjectMapper()
                    .readValue(req.getInputStream(), SignInRequest.class);
            
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUserName(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
    	String userName = ((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername();
    	Optional<User> userDetails = userServiceImpl.loadUserByUsername(userName);
    	
        String token = Jwts.builder()
                .setSubject(userDetails.get().getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret )
                .compact();
        
        res.addHeader("token", token);
        res.addHeader("userId", userDetails.get().getUsername());
    } 
    
	
}