package com.nhom13.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public abstract class BaseDTO {
	protected Long id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createdDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date modifiedDate;
	protected String createdBy;
	protected String modifiedBy;

}
