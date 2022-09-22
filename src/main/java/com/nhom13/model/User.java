package com.nhom13.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.nhom13.utility.datatype.ERole;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseModel {
	@NotBlank
	private String name;
	
	@NotEmpty
	@Column(length = 50)
	private String username;

	@Column(length = 120)
	private String password;
	
	@NotBlank
	private String phone;
	
	@Enumerated(EnumType.STRING)
	private ERole role;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;

}
