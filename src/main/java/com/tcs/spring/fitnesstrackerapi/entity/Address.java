package com.tcs.spring.fitnesstrackerapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@NotBlank
	private String addressLine1;
	private String addressLine2;
	@NotNull
	@NotBlank
	private String city;
	@NotNull
	private int pincode;
	@NotNull
	@NotBlank
	private String state;
	@NotNull
	@NotBlank
	private String country;

}
