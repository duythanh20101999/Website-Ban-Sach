package com.nhom13.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ChangePasswordRequest {
	protected String oldPassword;
	protected String newPassword;
	protected String confirmNewPassword;
	
}
