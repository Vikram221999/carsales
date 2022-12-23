package com.stg.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {
	
	@Id
	private int adminId;
	
	@NotEmpty
	private String adminName;
	
	@NotEmpty
	@Column(unique = true)
	private String adminPassword;
	
	@Email
	@NotEmpty
	@Column(unique = true)
	private String adminEmail;
	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "admin")
//	@JsonManagedReference
//	@Column(nullable = true)
//	private List<User> user;
//	


}
