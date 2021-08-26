package com.tcs.spring.fitnesstrackerapi.service;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tcs.spring.fitnesstrackerapi.entity.Appointment;
import com.tcs.spring.fitnesstrackerapi.exceptions.AddressValidatiomException;
import com.tcs.spring.fitnesstrackerapi.exceptions.AgeException;
import com.tcs.spring.fitnesstrackerapi.exceptions.AppointmentNotFoundException;
import com.tcs.spring.fitnesstrackerapi.exceptions.EmailVadilationException;
import com.tcs.spring.fitnesstrackerapi.exceptions.NameException;
import com.tcs.spring.fitnesstrackerapi.exceptions.PhoneNoValidationException;
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

	@Override
	public void updateAppointment(long id, Appointment appointment) {
		Optional<Appointment> appointmentFromDB = appointmentRepository.findById(id);
		if (!appointmentFromDB.isPresent())
			throw new AppointmentNotFoundException("Appointment does not exist to update");
		Appointment app1 = appointmentFromDB.get();
		if (StringUtils.hasText(appointment.getName()))
			app1.setName(appointment.getName());
		if (appointment.getAge() > 0 && appointment.getAge() < 80)
			app1.setAge(appointment.getAge());
		if (StringUtils.hasText(appointment.getEmail()))
			app1.setEmail(appointment.getEmail());
		if (StringUtils.hasText(appointment.getPhoneNo()))
			app1.setPhoneNo(appointment.getPhoneNo());
		if (appointment.getAddress() != null)
			app1.setAddress(appointment.getAddress());
		if (StringUtils.hasText(appointment.getTrainerPreference()))
			app1.setTrainerPreference(appointment.getTrainerPreference());
		if (appointment.isNeedOfPhysiotherapist() != app1.isNeedOfPhysiotherapist())
			app1.setNeedOfPhysiotherapist(appointment.isNeedOfPhysiotherapist());
		if (StringUtils.hasText(appointment.getPack()))
			app1.setPack(appointment.getPack());
		if (appointment.getWeeks() > 0)
			app1.setWeeks(appointment.getWeeks());
		if (appointment.getAmmount() > 0)
			app1.setAmmount(appointment.getAmmount());

		appointmentRepository.save(app1);
	}

}
