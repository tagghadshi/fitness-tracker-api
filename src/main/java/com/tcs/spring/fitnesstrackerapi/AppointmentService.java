package com.tcs.spring.fitnesstrackerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService implements IAppointmentService{

	@Autowired
	IAppointmentRepository appointmentRepository;
	
	@Override
	public void save(Appointment appointment) {
		appointmentRepository.save(appointment);
		System.out.println("Saved in Database");
	}

	@Override
	public Iterable<Appointment> retrieveAllAppointment() {
		return appointmentRepository.findAll();
	}

}
