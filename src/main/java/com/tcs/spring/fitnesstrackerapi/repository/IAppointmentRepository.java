package com.tcs.spring.fitnesstrackerapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.spring.fitnesstrackerapi.entity.Appointment;

public interface IAppointmentRepository extends CrudRepository<Appointment, Long>{

}
