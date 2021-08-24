package com.tcs.spring.fitnesstrackerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
//{
//    "name" : "Tejas Ghadshi",
//    "age"  : 78,
//    "email": "tejasghadshi@gmail.com" ,
//    "phoneNo" : "9090906666",
//    "address" : "Flat No 405,Sundar Appartment,Worli, Mumbai-400018",
//    "trainerPreference" : "Male Trainer",
//    "needOfPhysiotherapist" : false,
//    "pack" : "One Time Visit",
//    "weeks" :0,
//    "ammount" :500
//}
