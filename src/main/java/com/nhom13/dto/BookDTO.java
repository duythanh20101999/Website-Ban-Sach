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
	protected String authorname;
	protected String description;
	protected Long id_category;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId_category() {
		return id_category;
	}
	public void setId_category(Long id_category) {
		this.id_category = id_category;
	}
	

}
