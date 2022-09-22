package com.nhom13.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class OrderDeatailDTO extends BaseDTO {
	protected Long id_order;
	protected Long quantity;
	protected Long total;
	protected Long id_book;

}
