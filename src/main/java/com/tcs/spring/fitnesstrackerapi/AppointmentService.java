package com.tcs.spring.fitnesstrackerapi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService implements IAppointmentService {

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

	@Override
	public  Optional<Appointment> retrieveAppointment(long id) {
		Optional<Appointment> appointment = appointmentRepository.findById(id);
		if(!appointment.isPresent()) {
			throw new AppointmentNotFoundException("Appointment does not exist");
		}
		return appointment;
	}

	@Override
	public void deleteAppointment(long id) {
		appointmentRepository.deleteById(id);
	}

}
