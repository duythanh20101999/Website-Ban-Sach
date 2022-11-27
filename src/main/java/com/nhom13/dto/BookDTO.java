package com.nhom13.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class BookDTO extends BaseDTO {
	protected String name;
	protected Long price;
	private String image;
	protected String authorname;
	protected String description;
	protected Long id_category;

}
