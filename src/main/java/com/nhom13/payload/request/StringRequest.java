package com.nhom13.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StringRequest {
	@NotBlank
	private String text;
}
