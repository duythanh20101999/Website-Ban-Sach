package com.nhom13.service.impl;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import com.nhom13.dto.UserDTO;
import com.nhom13.model.User;
import com.nhom13.payload.request.ChangePasswordRequest;
import com.nhom13.payload.request.StringRequest;
import com.nhom13.payload.request.ResetPasswordRequest;
import com.nhom13.payload.response.DataResponse;

public interface ISignupService {
	
	DataResponse<UserDTO> createAdmin(UserDTO request, String role);
	
	void sendVerificationEmail(UserDTO user) throws UnsupportedEncodingException, MessagingException;
	
	DataResponse<UserDTO> createUser(UserDTO request) throws UnsupportedEncodingException, MessagingException;
	
	DataResponse<?> enableUser(String verify);
	DataResponse<?> updateResetPasswordCode(String email) throws UnsupportedEncodingException, MessagingException;
	DataResponse<?> updatePassword(HttpServletRequest request, ResetPasswordRequest password);
	
	DataResponse<?> changePassword(String username, ChangePasswordRequest passwordRequest);
}
