package com.nhom13.dto;

import com.nhom13.utility.datatype.ERole;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class UserDTO extends BaseDTO{
	protected String name;
	protected String password;
	protected String username;
	protected String phone;
	protected ERole role;
}
