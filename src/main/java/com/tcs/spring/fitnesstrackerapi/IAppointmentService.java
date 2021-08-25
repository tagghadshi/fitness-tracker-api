package com.tcs.spring.fitnesstrackerapi;

import java.util.Optional;

public interface IAppointmentService {
	void save(Appointment appointment);

	Iterable<Appointment> retrieveAllAppointment();

	Optional<Appointment> retrieveAppointment(long id);

	void deleteAppointment(long id);
}
