package com.Doctor.DoctorService.service;

import com.Doctor.DoctorService.dao.DoctorDao;
import com.Doctor.DoctorService.model.DoctorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServices {

    @Autowired
    DoctorDao doctordao;

    public ResponseEntity<List<DoctorModel>> getAllSchedules(){
        try{
            return new ResponseEntity<>(doctordao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    public ResponseEntity<String> addSchedule(DoctorModel doctormodel) {
        doctordao.save(doctormodel);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public DoctorModel getScheduleById(Integer id) {
        return doctordao.findById(id).orElse(null);
    }

    public ResponseEntity<List<DoctorModel>> getSchedulesByLocation(String location) {
        try {
            return new ResponseEntity<>(doctordao.findByLocation(location),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<DoctorModel>> getSchedulesByDoctorId(Integer doctorId) {
        try {
            return new ResponseEntity<>(doctordao.findByDoctorId(doctorId),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    } 

    public ResponseEntity<String> updateSchedule(Integer id, DoctorModel doctormodel) {
        if (doctordao.existsById(id)) {
            doctormodel.setId(id);
            doctordao.save(doctormodel);
            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Schedule not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> deleteSchedule(Integer id) {
        if (doctordao.existsById(id)) {
            doctordao.deleteById(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Schedule not found", HttpStatus.NOT_FOUND);
        }
    }

}
