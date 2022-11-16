package com.nhom13.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nhom13.utility.datatype.ERole;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotEmpty
	@Column(length = 50)
	private String username;

	@JsonIgnore
	@Column(length = 30)
	@Size(max = 30, min = 8)
	private String password;
	
	@NotBlank
	private String phone;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	
	@NotEmpty
	@Column(length = 50, unique = true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private ERole roles;
	
	@Column(name = "verification_code", updatable = true, length = 64)
	private String verificationCode;
	
	private boolean enabled;
	
	private boolean status;

	

	public User(@NotBlank String name, @NotEmpty String username, String password, @NotBlank String phone,
			@NotEmpty String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}


	public User(@NotBlank String name, @NotEmpty String username, String password, @NotBlank String phone,
			List<Order> orders, @NotEmpty String email, @NotEmpty ERole roles) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.orders = orders;
		this.email = email;
		this.roles = roles;
	}

}
