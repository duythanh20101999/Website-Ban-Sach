package com.nhom13.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResetPasswordRequest {
	protected String newPassword;
	protected String confirmPassword;

}
