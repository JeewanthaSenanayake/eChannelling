package com.echanneling.appointmentservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echanneling.appointmentservice.model.Appointment;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer> {
	
}
