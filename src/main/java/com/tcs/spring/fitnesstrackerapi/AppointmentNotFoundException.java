package com.tcs.spring.fitnesstrackerapi;

public class AppointmentNotFoundException extends RuntimeException {
	public AppointmentNotFoundException(String message) {
		super(message);
	}
}
