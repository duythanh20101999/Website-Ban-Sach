package com.nhom13.service.impl;

import com.nhom13.payload.request.LoginRequest;
import com.nhom13.payload.response.JwtResponse;

public interface ILoginService {
	JwtResponse authenticateUser(LoginRequest request);
}
