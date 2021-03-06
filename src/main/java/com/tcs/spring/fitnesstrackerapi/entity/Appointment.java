package com.tcs.spring.fitnesstrackerapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	@JsonIgnoreProperties("appointment")
	private User user;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;
	private String trainerPreference;
	private boolean needOfPhysiotherapist;
	private String pack;
	private byte weeks;
	private double ammount;
	
}
