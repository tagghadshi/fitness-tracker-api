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
		vaidation(appointment);
		appointmentRepository.save(appointment);
	}

	private void vaidation(Appointment appointment) {
		if (appointment.getName().length() < 6) 
			throw new NameException("Name should be atleast 4 characters");
		if(appointment.getName().isEmpty())
			throw new NameException("Name field cannt be empty");
		if (appointment.getAge() < 1 || appointment.getAge() > 100)
			throw new AgeException("Enter Valid Age");
		if (!emailValidation(appointment.getEmail()))
			throw new EmailVadilationException("Enter Valid Email");
		if (appointment.getPhoneNo().length() != 10) 
			throw new PhoneNoValidationException("Phone No should be 10 digits");
		if (appointment.getAddress() == null)
			throw new AddressValidatiomException("Address field should not be empty");

	}

	private boolean emailValidation(String email) {
		String emailRegex =  "^(.+)@(.+)$";

		Pattern pat = Pattern.compile(emailRegex);
		return pat.matcher(email).matches();
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
		if (appointment.getNeedOfPhysiotherapist() != app1.getNeedOfPhysiotherapist())
			app1.setNeedOfPhysiotherapist(appointment.getNeedOfPhysiotherapist());
		if (StringUtils.hasText(appointment.getPack()))
			app1.setPack(appointment.getPack());
		if (appointment.getWeeks() > 0)
			app1.setWeeks(appointment.getWeeks());
		if (appointment.getAmmount() > 0)
			app1.setAmmount(appointment.getAmmount());

		appointmentRepository.save(app1);
	}

}
