package com.tcs.spring.fitnesstrackerapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull(message = "Name is compulsory")
    @NotBlank(message = "Name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "Name has invalid characters")
	private String name;
	@NotNull
	@Min(value = 18, message = "Age must be greater than or equal to 18")
    @Max(value = 150, message = "Age must be less than or equal to 150")
	private byte age;
	@NotNull(message="Email Address is compulsory")
    @NotBlank(message="Email Address is compulsory")
    @Email(message = "Email Address is not a valid format")
	private String email;
	@NotBlank
	@NotNull
	private String phoneNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;
	private String trainerPreference;
	private boolean needOfPhysiotherapist;
	private String pack;
	private byte weeks;
	private double ammount;
	
}
