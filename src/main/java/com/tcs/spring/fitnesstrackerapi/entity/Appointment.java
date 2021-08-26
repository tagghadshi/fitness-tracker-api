package com.tcs.spring.fitnesstrackerapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@NotNull
	private String name;
	@NotNull
	private byte age;
	@NotNull
	@Email
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
