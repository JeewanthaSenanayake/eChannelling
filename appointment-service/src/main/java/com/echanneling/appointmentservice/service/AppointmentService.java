package com.echanneling.appointmentservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.echanneling.appointmentservice.dao.AppointmentDao;
import com.echanneling.appointmentservice.model.Appointment;

@Service
public class AppointmentService {
	
	@Autowired
    AppointmentDao appointmentDao;

	public ResponseEntity<List<Appointment>> getAllAppointments() {
		try {
            return new ResponseEntity<>(appointmentDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addAppointment(Appointment appointment) {
		appointmentDao.save(appointment);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
	}

}
