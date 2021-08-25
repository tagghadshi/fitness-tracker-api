package com.tcs.spring.fitnesstrackerapi.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.spring.fitnesstrackerapi.entity.Appointment;
import com.tcs.spring.fitnesstrackerapi.exceptions.AddressValidatiomException;
import com.tcs.spring.fitnesstrackerapi.exceptions.AgeException;
import com.tcs.spring.fitnesstrackerapi.exceptions.AppointmentNotFoundException;
import com.tcs.spring.fitnesstrackerapi.exceptions.EmailVadilationException;
import com.tcs.spring.fitnesstrackerapi.exceptions.NameException;
import com.tcs.spring.fitnesstrackerapi.exceptions.PhoneNoValidationException;
import com.tcs.spring.fitnesstrackerapi.service.IAppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

	@Autowired
	IAppointmentService appointmentService;

	@GetMapping
	public Iterable<Appointment> getAllAppointment() {
		return appointmentService.retrieveAllAppointment();
	}

	@GetMapping("/{id}")
	public Optional<Appointment> getAppointment(@PathVariable("id") long id) {
		return appointmentService.retrieveAppointment(id);
	}

	@PostMapping
	public void saveAppointment(@RequestBody Appointment appointment) {
		appointmentService.save(appointment);
		logger.debug("Saved in Database");
	}

	@DeleteMapping("/{id}")
	public void deleteAppointment(@PathVariable("id") long id) {
		appointmentService.deleteAppointment(id);
	}
	
	@PutMapping("/{id}")
	public void updateAppointment(@PathVariable("id") long id, @RequestBody Appointment appointment) {
		appointmentService.updateAppointment(id,appointment);
	}

	@ExceptionHandler(value = { AppointmentNotFoundException.class, EmptyResultDataAccessException.class })
	public ResponseEntity<Appointment> exception(RuntimeException runtimeException) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = { AgeException.class, AddressValidatiomException.class, EmailVadilationException.class,NameException.class, PhoneNoValidationException.class })
	public ResponseEntity<Appointment> exceptionValidation(RuntimeException runtimeException) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
