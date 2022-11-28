package com.nhom13.payload.response;

import java.sql.Date;
import java.util.List;

import com.nhom13.dto.BookDTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter @Setter
@RequiredArgsConstructor
public class OrderResponse {
	private Long id;
	private String name;
	private String phone;
	private String address;
	private List<BookResponse> books;
	private String status;
	private Date date;
	private Long total_price;
	private String username;
}
