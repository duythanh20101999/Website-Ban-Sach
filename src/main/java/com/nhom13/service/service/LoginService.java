package com.nhom13.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.nhom13.payload.request.LoginRequest;
import com.nhom13.payload.response.JwtResponse;
import com.nhom13.security.jwt.JwtProvider;
import com.nhom13.security.userprincipal.UserPrincipal;

@Service
public class LoginService {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;
	
	public JwtResponse authenticateUser(LoginRequest request, String rolePrefix) {
		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(rolePrefix + request.getUsername(), request.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtProvider.createToken(authentication, rolePrefix);
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		
		return new JwtResponse(token, userPrincipal.getUsername(), userPrincipal.getAuthorities());
	}

}
