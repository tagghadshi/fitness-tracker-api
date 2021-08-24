package com.tcs.spring.fitnesstrackerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

	@Autowired
	IAppointmentService appointmentService;

	@GetMapping("/appointments")
	private Iterable<Appointment> getAllAppointment() {
		return appointmentService.retrieveAllAppointment();
	}
	
	@PostMapping("/appointments")
	private void saveAppointment(@RequestBody Appointment appointment) {
		appointmentService.save(appointment);
	}
	
}

