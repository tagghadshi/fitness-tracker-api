package com.tcs.spring.fitnesstrackerapi.service;

import java.util.Optional;

import com.tcs.spring.fitnesstrackerapi.entity.Appointment;

public interface IAppointmentService {
	void save(Appointment appointment);

	Iterable<Appointment> retrieveAllAppointment();

	Optional<Appointment> retrieveAppointment(long id);

	void deleteAppointment(long id);

	void updateAppointment(long id, Appointment appointment);
}
