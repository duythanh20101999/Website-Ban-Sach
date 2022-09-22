package com.nhom13.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class OrderDTO extends BaseDTO {
	protected Long id_user;
	protected Long totalprice;
	protected Date date;
	protected Long id_payment;
	protected Integer status;

}
