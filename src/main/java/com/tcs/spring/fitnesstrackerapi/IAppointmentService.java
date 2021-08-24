package com.tcs.spring.fitnesstrackerapi;

public interface IAppointmentService {
	void save(Appointment appointment);
	Iterable<Appointment> retrieveAllAppointment();
}
