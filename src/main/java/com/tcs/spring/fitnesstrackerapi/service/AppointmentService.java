package com.tcs.spring.fitnesstrackerapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.spring.fitnesstrackerapi.entity.Appointment;
import com.tcs.spring.fitnesstrackerapi.exceptions.AppointmentNotFoundException;
import com.tcs.spring.fitnesstrackerapi.repository.IAppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService {

	@Autowired
	IAppointmentRepository appointmentRepository;

	@Override
	public void save(Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	@Override
	public Iterable<Appointment> retrieveAllAppointment() {
		return appointmentRepository.findAll();
	}

	@Override
	public Optional<Appointment> retrieveAppointment(long id) {
		Optional<Appointment> appointment = appointmentRepository.findById(id);
		if (!appointment.isPresent()) {
			throw new AppointmentNotFoundException("Appointment does not exist");
		}
		return appointment;
	}

	@Override
	public void deleteAppointment(long id) {
		appointmentRepository.deleteById(id);
	}

}
