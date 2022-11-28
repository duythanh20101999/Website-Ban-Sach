package com.nhom13.payload.response;

import com.nhom13.dto.CategoryDTO;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class BookResponse {
	protected Long id;
	protected String name;
	protected Long price;
	protected String image;
	protected String authorname;
	protected String description;
	protected CategoryDTO category;
	protected Long quantity;
}
