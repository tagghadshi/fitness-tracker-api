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
	@NotNull(message="Address is compulsory")
	@NotBlank(message="Address is compulsory")
	private String addressLine1;
	private String addressLine2;
	@NotNull(message="City is compulsory")
	@NotBlank(message="City is compulsory")
	private String city;
	@NotNull(message="Pincode is compulsory")
	private int pincode;
	@NotNull(message="State is compulsory")
	@NotBlank(message="State is compulsory")
	private String state;
	@NotNull(message="Country is compulsory")
	@NotBlank(message="Country is compulsory")
	private String country;

}
