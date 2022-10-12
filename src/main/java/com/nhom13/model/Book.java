package com.nhom13.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "Book")
@Table(name = "book")
public class Book extends BaseModel{
	@NotBlank
	private String name;
	
	@NotNull
	private Long price;
	
	@NotBlank
	private String authorname;
	
	@Lob
	@Column(length = 65535)
	@NotBlank
	private String description;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Category category;
	
	@OneToMany(mappedBy = "book")
	private List<OrderDetail> orderDetails;

}
